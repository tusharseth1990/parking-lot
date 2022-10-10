package DTO;

import enums.VehicleType;
import lombok.Data;

/**
 * Vehicle DTO/Model class
 */
@Data
public class Vehicle {
    private VehicleType vehicleType;
    private  String vehicleNumber;

    public Vehicle(VehicleType vehicleType, String vehicleNumber) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }
}
