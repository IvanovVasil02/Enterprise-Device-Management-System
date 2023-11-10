package ivanovvasil.u5d5w2Project.payloads;

import ivanovvasil.u5d5w2Project.enums.DeviceStatus;
import ivanovvasil.u5d5w2Project.enums.DeviceType;

public record NewDeviceDTO(DeviceType type,
                           String model,
                           DeviceStatus deviceStatus) {
}
