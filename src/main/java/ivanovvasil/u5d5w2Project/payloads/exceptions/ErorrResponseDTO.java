package ivanovvasil.u5d5w2Project.payloads.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class ErorrResponseDTO {
  private String message;
  private Date timestamp;
}
