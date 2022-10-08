package DTO;

import enums.VehicleType;

public class ParkingSpot {

    private Vehicle vehicle;
    private VehicleType vehicleType;
    private Integer spotId;
    private Boolean FILLED;



    public ParkingSpot(Vehicle vehicle, VehicleType vehicleType, Integer spotId, Boolean fill) {
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.spotId = spotId;
        FILLED = fill;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public Boolean getFILLED() {
        return FILLED;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setFILLED(Boolean FILLED) {
        this.FILLED = FILLED;
    }
}
