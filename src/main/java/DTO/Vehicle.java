package DTO;

import enums.VehicleType;
import lombok.Data;

/**
 * Vehicle DTO/Model class
 */
@Data
public class Vehicle {
    private final VehicleType vehicleType;
    private final String vehicleNumber;
}
