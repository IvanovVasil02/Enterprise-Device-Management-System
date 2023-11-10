package ivanovvasil.u5d5w2Project.payloads.exceptions;

import java.util.Date;
import java.util.List;

public record ErrorsListResponseDTO(String message,
                                    Date timeStamp,
                                    List<String> errorsList) {
}
