package ivanovvasil.u5d5w2Project.entities;

import com.github.javafaker.Faker;
import ivanovvasil.u5d5w2Project.enums.DeviceStatus;
import ivanovvasil.u5d5w2Project.enums.DeviceType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Entity
@Getter
@Setter
@Builder(builderClassName = "DeviceBuilder")
public class Device {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private DeviceType deviceType;
  private String Model;
  private DeviceStatus deviceStatus;
  @ManyToOne
  @JoinColumn(name="employee_id")
  private Employee employee;

  public static class DeviceBuilder{
    Faker f = new Faker(Locale.ITALY);
    private DeviceType deviceType = DeviceType.getRandomDeviceType();
    private String Model = f.team().name();
    private DeviceStatus deviceStatus = DeviceStatus.getRandomDeviceStatus();
  }
}
