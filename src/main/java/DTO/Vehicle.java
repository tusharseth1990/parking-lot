package DTO;

import enums.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    private final VehicleType vehicleType;
    private final String vehicleNumber;
}
