package DTO;

import enums.VehicleType;
import lombok.Data;

/**
 * ParkingFee model class
 */
@Data
public class ParkingFee {

    private final VehicleType vehicleType;
    private final Integer fee;
    private final Integer minInterval;
    private final Integer maxInterval;
}
