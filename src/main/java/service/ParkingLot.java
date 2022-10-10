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



/**
 * ParkingLot class for parking & un-park vehicle
 */
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

    /**
     * To Park the Vehicle in particular Parking Location.
     * @param vehicle vehicle details
     * @param parkingLocation parkingLocation details
     * @return parkingTicket parking Ticket Details
     */
    public ParkingTicket parkVehicle(Vehicle vehicle, ParkingLocation parkingLocation) {
        //if spot available for particular vehicle type then
        //assign parking spot &
        //give a parking ticket
        ParkingTicket parkingTicket = null;
        Boolean available = checkParkingSpotAvailability(vehicle.getVehicleType());
        if (available) {
            switch (vehicle.getVehicleType()) {
                case BIKE -> parkingTicket = getParkingTicket(vehicle, parkedSpotsBike, parkingLocation);
                case CAR -> parkingTicket = getParkingTicket(vehicle,  parkedSpotsCar, parkingLocation);
                case TRUCK -> parkingTicket = getParkingTicket(vehicle,  parkedSpotsTruck, parkingLocation);
            }
        }
        return parkingTicket;
    }

    private ParkingTicket getParkingTicket(Vehicle vehicle, boolean[] parkedSpots, ParkingLocation parkingLocation) {
        ParkingTicket parkingTicket = null;
        for (int i = 0; i < parkedSpots.length; i++) {
            if (parkedSpots[i] == Boolean.FALSE) {
                ParkingSpot parkingSpot = new ParkingSpot(vehicle, vehicle.getVehicleType(), i, true);
                parkedSpots[i] = true;
                parkingTicket = new ParkingTicket(ticketSequenceGenerator++,
                        new Timestamp(System.currentTimeMillis()), parkingSpot, parkingLocation);
                parkingSpots.add(parkingSpot);
            }
        }
        return parkingTicket;
    }

    private Boolean checkParkingSpotAvailability(VehicleType vehicleType) {
        return (vehicleType.equals(VehicleType.BIKE) && parkedSpotsBike.length < bikeLimit)
                || (vehicleType.equals(VehicleType.CAR) && parkedSpotsCar.length < carLimit)
                || (vehicleType.equals(VehicleType.TRUCK) && parkedSpotsTruck.length < truckLimit);
    }

    /**
     * To Un-Park the Vehicle in particular Parking Location.
     * @param parkingTicket parkingTicket details
     * @return ParkingReceipt parking Receipt Details
     */
    public ParkingReceipt unParkVehicle(ParkingTicket parkingTicket) throws IOException {
        //leave the parking slot
        parkingSpots.remove(parkingTicket.getParkingSpot());
        VehicleType vehicleType = parkingTicket.getParkingSpot().getVehicleType();
        switch (vehicleType) {
            case BIKE -> parkedSpotsBike[parkingTicket.getParkingSpot().getSpotId()] = false;
            case CAR ->   parkedSpotsCar[parkingTicket.getParkingSpot().getSpotId()] = false;
            case TRUCK ->  parkedSpotsTruck[parkingTicket.getParkingSpot().getSpotId()] = false;
        }

        // Calculate fees
        ParkingReceipt parkingReceipt = new ParkingReceipt();
        Double fees = parkingReceipt.calcParkingFees(parkingTicket);
        parkingReceipt.setParkingTicket(parkingTicket);
        parkingReceipt.setReceiptNumber(receiptSequenceGenerator++);
        parkingReceipt.setExitDateTime( new Timestamp(System.currentTimeMillis()));
        parkingReceipt.setFees(fees);
        //Receipt to be generated
        return parkingReceipt;
    }
}
