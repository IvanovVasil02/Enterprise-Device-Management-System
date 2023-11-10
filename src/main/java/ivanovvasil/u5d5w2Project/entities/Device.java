package ivanovvasil.u5d5w2Project.entities;

import com.github.javafaker.Faker;
import ivanovvasil.u5d5w2Project.enums.DeviceStatus;
import ivanovvasil.u5d5w2Project.enums.DeviceType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "DeviceBuilder")
public class Device {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Enumerated(EnumType.STRING)
  private DeviceType deviceType;
  private String Model;
  @Enumerated(EnumType.STRING)
  private DeviceStatus deviceStatus;
  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public static class DeviceBuilder {
    Faker f = new Faker(Locale.ITALY);
    private DeviceType deviceType = DeviceType.getRandomDeviceType();
    private String Model = f.team().name();
    
  }
}
