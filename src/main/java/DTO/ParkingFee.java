package DTO;

import enums.VehicleType;

public class ParkingFee {

    private final VehicleType vehicleType;
    private final Integer fee;
    private final Integer minInterval;
    private final Integer maxInterval;

    public ParkingFee(VehicleType vehicleType, Integer fee, Integer minInterval, Integer maxInterval) {
        this.vehicleType = vehicleType;
        this.fee = fee;
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
    }


}
