package ivanovvasil.u5d5w2Project.services;

import com.cloudinary.Cloudinary;
import ivanovvasil.u5d5w2Project.entities.Employee;
import ivanovvasil.u5d5w2Project.exceptions.BadRequestException;
import ivanovvasil.u5d5w2Project.exceptions.NotFoundException;
import ivanovvasil.u5d5w2Project.payloads.NewEmployeeDTO;
import ivanovvasil.u5d5w2Project.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeesService {
  @Autowired
  private EmployeesRepository employeesRepository;
  @Autowired
  private Cloudinary cloudinary;

  //findALl for employees runner
  public Employee saveRunnerEmployee(Employee employee) {
    return employeesRepository.save(employee);
  }

  public Employee save(NewEmployeeDTO body) throws IOException {
    employeesRepository.findByEmail(body.email()).ifPresent(author -> {
      throw new BadRequestException("The email  " + author.getEmail() + " is already used!");
    });
    Employee newEmployee = new Employee();
    newEmployee.setName(body.name());
    newEmployee.setSurname(body.surname());
    newEmployee.setEmail(body.email());
    if (body.profilePicture() != null) {
      newEmployee.setProfilePicture(body.profilePicture());
    } else {
      newEmployee.setProfilePicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC0HlQ_ckX6HqCAlqroocyRDx_ZRu3x3ezoA&usqp=CAU");
    }
    return employeesRepository.save(newEmployee);
  }

  //findALl for employees runner
  public List<Employee> findAll() {
    return employeesRepository.findAll();
  }

  public Page<Employee> findAll(int page, int size, String orderBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
    return employeesRepository.findAll(pageable);
  }

  public Employee findById(int id) throws NotFoundException {
    return employeesRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  public void findByIdAndDelete(int id) throws NotFoundException {
    employeesRepository.delete(this.findById(id));
  }

  public Employee findByIdAndUpdate(int id, Employee body) throws NotFoundException {
    Employee found = this.findById(id);
    found.setName(body.getName());
    found.setSurname(body.getSurname());
    found.setEmail(body.getEmail());
    return employeesRepository.save(found);
  }

}
