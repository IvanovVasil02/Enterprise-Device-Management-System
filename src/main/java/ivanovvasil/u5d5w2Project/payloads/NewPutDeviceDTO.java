package ivanovvasil.u5d5w2Project.payloads;

import ivanovvasil.u5d5w2Project.enums.DeviceStatus;
import ivanovvasil.u5d5w2Project.enums.DeviceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPutDeviceDTO(@NotNull(message = "The device type is a required field")
                              DeviceType deviceType,
                              @NotEmpty(message = "The device model is a required field")
                              String model,
                              @NotNull(message = "The device model is a required field")
                              DeviceStatus deviceStatus,
                              int employee
) {
}
