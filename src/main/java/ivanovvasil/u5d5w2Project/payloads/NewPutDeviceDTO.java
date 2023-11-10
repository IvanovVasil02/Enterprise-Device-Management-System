package ivanovvasil.u5d5w2Project.payloads;

import ivanovvasil.u5d5w2Project.enums.DeviceStatus;
import ivanovvasil.u5d5w2Project.enums.DeviceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPutDeviceDTO(@NotNull(message = "The device type field cannot be empty")
                              DeviceType deviceType,
                              @NotEmpty(message = "The device model field cannot be empty")
                              String model,
                              @NotNull(message = "The device status field cannot be empty")
                              DeviceStatus deviceStatus,
                              int employee
) {
}
