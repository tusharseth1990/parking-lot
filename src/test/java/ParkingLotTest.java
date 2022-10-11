import DTO.ParkingReceipt;
import DTO.ParkingTicket;
import DTO.Vehicle;
import enums.ParkingLocation;
import enums.VehicleType;
import exception.ParkingLotException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.ParkingLot;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkingLotTest {

    @Test
    void parkVehicleCarInMall(){
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, "UP32-5674");
        ParkingTicket parkingTicket1 = parkingLot1.parkVehicle(vehicle1, ParkingLocation.MALL);
        assertEquals(ParkingLocation.MALL, parkingTicket1.getParkingLocation());
        assertEquals(VehicleType.CAR,parkingTicket1.getParkingSpot().getVehicleType());
        assertNotNull(parkingTicket1.getParkingSpot().getSpotId());
    }

    @Test
    void parkVehicleBikeInStadium(){
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(VehicleType.BIKE, "UP78-7865");
        ParkingTicket parkingTicket1 = parkingLot1.parkVehicle(vehicle1, ParkingLocation.STADIUM);
        assertEquals(ParkingLocation.STADIUM, parkingTicket1.getParkingLocation());
        assertEquals(VehicleType.BIKE,parkingTicket1.getParkingSpot().getVehicleType());
        assertNotNull(parkingTicket1.getParkingSpot().getSpotId());

    }

    @Test
    void parkVehicleNegativeCaseForVehicle(){
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(null, "UP32-5674");
        assertThrows(ParkingLotException.class, () -> parkingLot1.parkVehicle(vehicle1, ParkingLocation.MALL));
    }

    @Test
    void parkVehicleNegativeCaseForLocation(){
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, "UP32-5674");
        assertThrows(ParkingLotException.class, () -> parkingLot1.parkVehicle(vehicle1, null));
    }

    @Test
    void parkAndUnParkVehicleCarFromMall(){
        ParkingLot parkingLot2 = new ParkingLot();
        Vehicle vehicle2 = new Vehicle(VehicleType.CAR, "UP70-9845");
        ParkingTicket parkingTicket2 = parkingLot2.parkVehicle(vehicle2, ParkingLocation.MALL);
        parkingTicket2.setEntryDateTime(new Timestamp(System.currentTimeMillis()-20000000));

        ParkingReceipt parkingReceipt = parkingLot2.unParkVehicle(parkingTicket2);
        assertNotNull(parkingReceipt.getParkingTicket().getTicketNumber());
        assertNotNull(parkingReceipt.getParkingTicket().getParkingSpot().getSpotId());
        assertEquals(parkingReceipt.getFees(),120);
    }


    @Test
    void parkAndUnParkVehicleBikeFromAirport(){
        ParkingLot parkingLot2 = new ParkingLot();
        Vehicle vehicle2 = new Vehicle(VehicleType.BIKE, "UP32-0976");
        ParkingTicket parkingTicket2 = parkingLot2.parkVehicle(vehicle2, ParkingLocation.AIRPORT);
        parkingTicket2.setEntryDateTime(new Timestamp(System.currentTimeMillis()-20000000));

        ParkingReceipt parkingReceipt = parkingLot2.unParkVehicle(parkingTicket2);
        assertNotNull(parkingReceipt.getParkingTicket().getTicketNumber());
        assertNotNull(parkingReceipt.getParkingTicket().getParkingSpot().getSpotId());
        assertEquals(parkingReceipt.getFees(),40);
    }

    @Test
    void parkAndUnParkVehicleBikeFromAirportNegative(){
        ParkingLot parkingLot2 = new ParkingLot();
        assertThrows(ParkingLotException.class, () -> parkingLot2.unParkVehicle(null));
    }

    @Test
    void parkAndUnParkVehicleCarFromMallNegative(){
        ParkingLot parkingLot2 = new ParkingLot();
        assertThrows(ParkingLotException.class, () ->  parkingLot2.unParkVehicle(null));

    }

}
