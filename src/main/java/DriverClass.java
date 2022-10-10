import DTO.ParkingTicket;
import DTO.Vehicle;
import enums.ParkingLocation;
import enums.VehicleType;
import service.ParkingLot;

import java.io.IOException;
import java.sql.Timestamp;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, "UP32-1234");
        ParkingTicket parkingTicket1 = parkingLot1.parkVehicle(vehicle1, ParkingLocation.MALL);
        System.out.println(parkingTicket1);
        ParkingLot parkingLot2 = new ParkingLot();
        Vehicle vehicle2 = new Vehicle(VehicleType.CAR, "UP32-4321");
        ParkingTicket parkingTicket2 = parkingLot2.parkVehicle(vehicle2, ParkingLocation.MALL);
        System.out.println(parkingTicket2);
        ParkingLot parkingLot3 = new ParkingLot();
        Vehicle vehicle3 = new Vehicle(VehicleType.CAR, "UP32-4310");
        ParkingTicket parkingTicket3 = parkingLot3.parkVehicle(vehicle3, ParkingLocation.MALL);
        System.out.println(parkingTicket3);

        //Unpark with parking ticket 2
        parkingTicket2.setEntryDateTime(new Timestamp(System.currentTimeMillis()-10000000));
        System.out.println(parkingLot2.unParkVehicle(parkingTicket2));

    }
}
