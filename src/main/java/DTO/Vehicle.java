package DTO;

import enums.VehicleType;

public class Vehicle {
    private final VehicleType vehicleType;
    private final String vehicleNumber;

    private String getVehicleNumber() {
        return vehicleNumber;
    }

    public Vehicle(VehicleType vehicleType, String vehicleNumber) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
