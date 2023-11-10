package ivanovvasil.u5d5w2Project.services;

import com.cloudinary.Cloudinary;
import ivanovvasil.u5d5w2Project.entities.Employee;
import ivanovvasil.u5d5w2Project.exceptions.NotFoundException;
import ivanovvasil.u5d5w2Project.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {
  @Autowired
  private EmployeesRepository employeesRepository;
  @Autowired
  private Cloudinary cloudinary;

  public Employee saveRunnerEmployee(Employee employee) {
    return employeesRepository.save(employee);
  }


  public List<Employee> findAll() {
    return employeesRepository.findAll();
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
