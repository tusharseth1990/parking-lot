import DTO.ParkingTicket;
import DTO.Vehicle;
import enums.ParkingLocation;
import enums.VehicleType;
import exception.ParkingLotException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import service.ParkingLot;

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
        assertTrue(parkingTicket1.getParkingSpot().getSpotId()!=null);
    }

    @Test
    void parkVehicleBikeInStadium(){
        ParkingLot parkingLot1 = new ParkingLot();
        Vehicle vehicle1 = new Vehicle(VehicleType.BIKE, "UP78-7865");
        ParkingTicket parkingTicket1 = parkingLot1.parkVehicle(vehicle1, ParkingLocation.STADIUM);
        //System.out.println(parkingTicket1);
        assertEquals(ParkingLocation.STADIUM, parkingTicket1.getParkingLocation());
        assertEquals(VehicleType.BIKE,parkingTicket1.getParkingSpot().getVehicleType());
        assertTrue(parkingTicket1.getParkingSpot().getSpotId()!=null);

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
}
