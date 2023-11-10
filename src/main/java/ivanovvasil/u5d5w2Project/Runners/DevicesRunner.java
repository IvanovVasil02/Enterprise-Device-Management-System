package ivanovvasil.u5d5w2Project.Runners;

import ivanovvasil.u5d5w2Project.entities.Device;
import ivanovvasil.u5d5w2Project.entities.Employee;
import ivanovvasil.u5d5w2Project.services.DevicesService;
import ivanovvasil.u5d5w2Project.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Order(2)
public class DevicesRunner implements CommandLineRunner {
  @Autowired
  private DevicesService devicesService;
  @Autowired
  private EmployeesService employeesService;

  @Override
  public void run(String... args) throws Exception {
    for (int i = 0; i < 40; i++) {
      List<Employee> employees = employeesService.findAll();
      Device newDevice = Device.builder().employee(employees.get(new Random().nextInt(0, employees.size() - 1))).build();
      devicesService.saveDeviceRunner(newDevice);
    }
  }
}
