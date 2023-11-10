package ivanovvasil.u5d5w2Project.entities;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Entity
@Getter
@Setter
@Builder(builderClassName = "EmployeeBuilder")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private String surname;
  private String email;

  public static class EmployeeBuilder{  
    Faker f = new Faker(Locale.ITALY);
    private String name = f.name().name();
    private String surname = f.name().lastName();
    private String email = f.internet().emailAddress();
  }
}
