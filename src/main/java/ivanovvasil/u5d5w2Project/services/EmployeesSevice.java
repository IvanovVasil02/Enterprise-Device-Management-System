package ivanovvasil.u5d5w2Project.services;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ivanovvasil.u5d5w2Project.entities.Employee;
import ivanovvasil.u5d5w2Project.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeesSevice {
  @Autowired
  private EmployeesRepository employeesRepository;
  @Autowired
  private Cloudinary cloudinary;

  public Employee saveRunnerEmployee(Employee employee) {
    return employeesRepository.save(employee);
  }

  public Employee save(EmployeeDTO body) throws IOException {
    employeesRepository.findByEmail(body.email()).ifPresent(employee -> {
      throw new BadRequestException("L'email " + employee.getEmail() + " è già utilizzata!");
    });

    Employee newEmployee = new Employee();
    Employee.setName(body.name());
    Employee.setSurname(body.surname());
    Employee.setEmail(body.email());
    Employee.setBirthDate(body.birthDate());
    Employee.setAvatar("http://ui-avatars.com/api/?name=" + Employee.getName() + "+" + Employee.getSurname());
    return employeesRepository.save(Employee);
  }

  public Page<Employee> findAll(int page, int size, String orderBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
    return employeesRepository.findAll(pageable);
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
    found.setBirthDate(body.getBirthDate());
    return employeesRepository.save(found);
  }

  public Employee uploadImg(int id, MultipartFile file) throws IOException {
    Employee found = this.findById(id);
    String urlImg = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
    found.setAvatar(urlImg);
    return found;
  }
}
