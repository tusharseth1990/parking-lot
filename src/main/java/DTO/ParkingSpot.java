package DTO;

import enums.VehicleType;
import lombok.Data;

/**
 * ParkingSpot DTO/Model class
 */

@Data
public class ParkingSpot {

    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Integer spotId;
    private Boolean FILLED;

    public ParkingSpot(Vehicle vehicle, VehicleType vehicleType, Integer spotId, Boolean FILLED) {
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.spotId = spotId;
        this.FILLED = FILLED;
    }
}
