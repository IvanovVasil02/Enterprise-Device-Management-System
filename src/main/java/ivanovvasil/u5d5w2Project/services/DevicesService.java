package ivanovvasil.u5d5w2Project.services;

import ivanovvasil.u5d5w2Project.entities.Device;
import ivanovvasil.u5d5w2Project.exceptions.NotFoundException;
import ivanovvasil.u5d5w2Project.payloads.NewDeviceDTO;
import ivanovvasil.u5d5w2Project.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DevicesService {
  @Autowired
  private DevicesRepository devicesRepository;
  @Autowired
  private EmployeesService employesServices;

  //to save blog post whit runner
  public Device saveDeviceRunner(Device body) {
    return devicesRepository.save(body);
  }

  public Device save(NewDeviceDTO body) throws IOException {
    Device newDevice = new Device();
    newDevice.setDeviceType(body.deviceType());
    newDevice.setModel(body.model());
    newDevice.setDeviceStatus(body.deviceStatus());
    return devicesRepository.save(newDevice);
  }

  public Page<Device> findAll(int page, int size, String orderBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
    return devicesRepository.findAll(pageable);
  }

  public Device findById(int id) throws NotFoundException {
    return devicesRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  public void findByIdAndDelete(int id) throws NotFoundException {
    devicesRepository.delete(this.findById(id));
  }

  public Device findByIdAndUpdate(int id, Device body) throws NotFoundException {
    Device found = this.findById(id);
    found.setDeviceType(body.getDeviceType());
    found.setModel(body.getModel());
    found.setDeviceStatus(body.getDeviceStatus());
    found.setEmployee(body.getEmployee());
    return devicesRepository.save(found);
  }
}
