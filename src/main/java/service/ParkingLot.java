package service;

import Config.VehicleCapacity;
import DTO.ParkingReceipt;
import DTO.ParkingSpot;
import DTO.ParkingTicket;
import DTO.Vehicle;
import enums.ParkingLocation;
import enums.VehicleType;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private VehicleCapacity vehicleCapacity;

    List<ParkingSpot> parkingSpots = new ArrayList<>();

    private Integer bikeLimit = vehicleCapacity.getVehicleCapacity(VehicleType.BIKE);
    private Integer carLimit = vehicleCapacity.getVehicleCapacity(VehicleType.CAR);
    private Integer truckLimit = vehicleCapacity.getVehicleCapacity(VehicleType.TRUCK);

    boolean[] parkedSpotsBike = new boolean[bikeLimit];
    boolean[] parkedSpotsCar = new boolean[carLimit];
    boolean[] parkedSpotsTruck = new boolean[truckLimit];

    private Integer ticketSequenceGenerator = 0;
    private Integer receiptSequenceGenerator = 0;


    public ParkingLot() throws IOException {
    }


    public ParkingTicket parkVehicle(Vehicle vehicle, ParkingLocation parkingLocation) {
        //if spot available for particular vehicle type then
        //assign parking spot &
        //give a parking ticket
        ParkingTicket parkingTicket = null;
        Boolean available = checkParkingSpotAvailability(vehicle.getVehicleType());
        if (available) {
            switch (vehicle.getVehicleType()) {
                case BIKE -> parkingTicket = getParkingTicket(vehicle, parkingTicket, parkedSpotsBike, parkingLocation);
                case CAR -> parkingTicket = getParkingTicket(vehicle, parkingTicket, parkedSpotsCar, parkingLocation);
                case TRUCK -> parkingTicket = getParkingTicket(vehicle, parkingTicket, parkedSpotsTruck, parkingLocation);
            }
        }
        return parkingTicket;
    }

    private ParkingTicket getParkingTicket(Vehicle vehicle, ParkingTicket parkingTicket, boolean[] parkedSpots, ParkingLocation parkingLocation) {
        for (int i = 0; i < parkedSpots.length; i++) {
            if (parkedSpots[i] == Boolean.FALSE) {
                ParkingSpot parkingSpot = new ParkingSpot(vehicle, vehicle.getVehicleType(), i, true);
                parkingTicket = new ParkingTicket(ticketSequenceGenerator++,
                        new Timestamp(System.currentTimeMillis()), parkingSpot, parkingLocation);
                parkingSpots.add(parkingSpot);
            }
        }
        return parkingTicket;
    }

    private Boolean checkParkingSpotAvailability(VehicleType vehicleType) {
        return vehicleType.equals(VehicleType.BIKE) && parkedSpotsBike.length < bikeLimit
                || vehicleType.equals(VehicleType.CAR) && parkedSpotsCar.length < carLimit
                || vehicleType.equals(VehicleType.TRUCK) && parkedSpotsTruck.length < truckLimit;
    }

    public ParkingReceipt unParkVehicle(ParkingTicket parkingTicket) {
        //leave the parking slot i.e. make Fill = false
        parkingSpots.remove(parkingTicket.getParkingSpot());
//        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
//        parkingSpot.setVehicle(null);
//        parkingSpot.setFILLED(false);

        // Calculate fees
        ParkingReceipt parkingReceipt = new ParkingReceipt();
        Double fees = parkingReceipt.getFees();
        parkingReceipt.setParkingTicket(parkingTicket);
        parkingReceipt.setReceiptNumber(receiptSequenceGenerator++);
        parkingReceipt.setExitDateTime( new Timestamp(System.currentTimeMillis()));
        parkingReceipt.setFees(fees);
        //Receipt to be generated
        return parkingReceipt;
    }
}
