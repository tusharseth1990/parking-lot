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

    @Test
    void parkAndUnParkBikeFromAirport(){
        ParkingLot parkingLot27 = new ParkingLot();
        Vehicle vehicle27 = new Vehicle(VehicleType.BIKE, "UP32-0878");
        ParkingTicket parkingTicket27 = parkingLot27.parkVehicle(vehicle27, ParkingLocation.STADIUM);
        parkingTicket27.setEntryDateTime(new Timestamp(System.currentTimeMillis()-1800000));
        ParkingReceipt parkingReceipt27 = parkingLot27.unParkVehicle(parkingTicket27);
        assertEquals(30,parkingReceipt27.getFees());
    }

    @Test
    void parkAndUnParkBike2FromAirport(){
        ParkingLot parkingLot25 = new ParkingLot();
        Vehicle vehicle25 = new Vehicle(VehicleType.CAR, "UP32-1234");
        ParkingTicket parkingTicket25 = parkingLot25.parkVehicle(vehicle25, ParkingLocation.AIRPORT);
        System.out.println(parkingTicket25);
        //10800000 - 3 hours
        parkingTicket25.setEntryDateTime(new Timestamp(System.currentTimeMillis()-10800000));
        ParkingReceipt parkingReceipt25= parkingLot25.unParkVehicle(parkingTicket25);
        assertEquals(60,parkingReceipt25.getFees());
    }

    @Test
    void parkAndUnParkBike3rdFromAirport(){
        ParkingLot parkingLot26 = new ParkingLot();
        Vehicle vehicle26 = new Vehicle(VehicleType.CAR, "UP32-7567");
        ParkingTicket parkingTicket26 = parkingLot26.parkVehicle(vehicle26, ParkingLocation.AIRPORT);
        //32400000- 9 hours
        parkingTicket26.setEntryDateTime(new Timestamp(System.currentTimeMillis()-32400000));
       ParkingReceipt parkingReceipt = parkingLot26.unParkVehicle(parkingTicket26);
       assertEquals(60,parkingReceipt.getFees());
    }


    @Test
    void parkAndUnParkBike4thFromAirport(){
        ParkingLot parkingLot28 = new ParkingLot();
        Vehicle vehicle28 = new Vehicle(VehicleType.CAR, "UP32-9739");
        ParkingTicket parkingTicket28 = parkingLot28.parkVehicle(vehicle28, ParkingLocation.AIRPORT);
        parkingTicket28.setEntryDateTime(new Timestamp(System.currentTimeMillis()-86500000));
        ParkingReceipt parkingReceipt = parkingLot28.unParkVehicle(parkingTicket28);//         86400000- 1 day
        assertEquals(200,parkingReceipt.getFees());
    }

    @Test
    void parkAndUnParkBikeInStadium(){
        ParkingLot parkingLot21 = new ParkingLot();
        Vehicle vehicle21 = new Vehicle(VehicleType.BIKE, "UP32-1234");
        ParkingTicket parkingTicket21 = parkingLot21.parkVehicle(vehicle21, ParkingLocation.STADIUM);
        //32400000- 9 hours
        parkingTicket21.setEntryDateTime(new Timestamp(System.currentTimeMillis()-32400000));
        ParkingReceipt parkingReceipt = parkingLot21.unParkVehicle(parkingTicket21);
        assertEquals(90,parkingReceipt.getFees());

    }
@Test
    void parkAndUnParkBike2ndCaseInStadium(){
        ParkingLot parkingLot23 = new ParkingLot();
        Vehicle vehicle23 = new Vehicle(VehicleType.BIKE, "UP32-0878");
        ParkingTicket parkingTicket23 = parkingLot23.parkVehicle(vehicle23, ParkingLocation.STADIUM);
        parkingTicket23.setEntryDateTime(new Timestamp(System.currentTimeMillis()-86500000));
        ParkingReceipt parkingReceipt = parkingLot23.unParkVehicle(parkingTicket23);//         86400000- 1 day
        assertEquals(1390,parkingReceipt.getFees());
    }

    @Test
    void parkAndUnParkBike3rdCaseInStadium(){
        ParkingLot parkingLot24 = new ParkingLot();
        Vehicle vehicle24 = new Vehicle(VehicleType.BIKE, "UP32-9739");
        ParkingTicket parkingTicket24 = parkingLot24.parkVehicle(vehicle24, ParkingLocation.STADIUM);
        //10800000 - 3 hours
        parkingTicket24.setEntryDateTime(new Timestamp(System.currentTimeMillis()-10800000));
        ParkingReceipt parkingReceipt = parkingLot24.unParkVehicle(parkingTicket24);
        assertEquals(30,parkingReceipt.getFees());
    }
}
