package Config;

import DTO.ParkingFee;
import enums.VehicleType;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FeeModel {
    FileReader reader;
    Properties p = new Properties();

    public FeeModel() throws IOException {
        reader = new FileReader("feemodels.properties");
        p.load(reader);
    }

    public List<ParkingFee> getMallFeeModel() {
        List<ParkingFee> mallParkingFeeList = new ArrayList<>();
        Integer MallBikeFee = Integer.valueOf(p.getProperty("MALL.BIKE"));
        ParkingFee parkingFeeBike = new ParkingFee(VehicleType.BIKE, MallBikeFee, null, null);
        mallParkingFeeList.add(parkingFeeBike);

        Integer MallCarFee = Integer.valueOf(p.getProperty("MALL.CAR"));
        ParkingFee parkingFeeCar = new ParkingFee(VehicleType.CAR, MallCarFee, null, null);
        mallParkingFeeList.add(parkingFeeCar);

        Integer MallTruckFee = Integer.valueOf(p.getProperty("MALL.TRUCK"));
        ParkingFee parkingFeeTruck = new ParkingFee(VehicleType.TRUCK, MallTruckFee, null, null);
        mallParkingFeeList.add(parkingFeeTruck);
        return mallParkingFeeList;
    }

    public List<ParkingFee> getStadiumFeeModel() {
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        parkingFeeList.addAll(BikeInStadiumFee());
        parkingFeeList.addAll(CarInStadiumFee());
        return parkingFeeList;
    }

    public List<ParkingFee> getAirportFeeModel() {
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        parkingFeeList.addAll(BikeInAirportFee());
        parkingFeeList.addAll(CarInAirportFee());
        return parkingFeeList;
    }

    private List<ParkingFee> CarInAirportFee() {
        List<ParkingFee> carInAirportParkingFeeList = new ArrayList<>();
        Integer AirportCarFeeONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE"));
        Integer AirportCarMININTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer AirportCarMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportCarOne = new ParkingFee(VehicleType.CAR, AirportCarFeeONE, AirportCarMININTONE, AirportCarMAXINTONE);
        carInAirportParkingFeeList.add(parkingFeeAirportCarOne);

        Integer AirportCarFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE"));
        Integer AirportCarMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer AirportCarMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportCarTwo = new ParkingFee(VehicleType.CAR, AirportCarFeeTwo, AirportCarMININTTWO, AirportCarMAXINTTWO);
        carInAirportParkingFeeList.add(parkingFeeAirportCarTwo);

        Integer AirportCarFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_PER_DAY"));
        ParkingFee parkingFeeAirportCarPerDay = new ParkingFee(VehicleType.CAR, AirportCarFeePerDay, null, null);
        carInAirportParkingFeeList.add(parkingFeeAirportCarPerDay);
        return carInAirportParkingFeeList;
    }

    private List<ParkingFee> BikeInAirportFee() {
        List<ParkingFee> bikeInAirportParkingFee = new ArrayList<>();
        Integer AirportBikeFeeONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE"));
        Integer AirportBikeMININTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeOne = new ParkingFee(VehicleType.BIKE, AirportBikeFeeONE, AirportBikeMININTONE, AirportBikeMAXINTONE);
        bikeInAirportParkingFee.add(parkingFeeAirportBikeOne);

        Integer AirportBikeFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE"));
        Integer AirportBikeMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeTwo = new ParkingFee(VehicleType.BIKE, AirportBikeFeeTwo, AirportBikeMININTTWO, AirportBikeMAXINTTWO);
        bikeInAirportParkingFee.add(parkingFeeAirportBikeTwo);

        Integer AirportBikeFeeThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE"));
        Integer AirportBikeMININTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeThree = new ParkingFee(VehicleType.BIKE, AirportBikeFeeThree, AirportBikeMININTThree, AirportBikeMAXINTThree);
        bikeInAirportParkingFee.add(parkingFeeAirportBikeThree);

        Integer AirportBikeFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_PER_DAY"));
        ParkingFee parkingFeeAirportBikePerDay = new ParkingFee(VehicleType.BIKE, AirportBikeFeePerDay, null, null);
        bikeInAirportParkingFee.add(parkingFeeAirportBikePerDay);
        return bikeInAirportParkingFee;
    }

    private List<ParkingFee> CarInStadiumFee() {
        List<ParkingFee> carInStadiumParkingFee = new ArrayList<>();
        Integer StadiumCarFeeONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE"));
        Integer StadiumCarMININTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarOne = new ParkingFee(VehicleType.CAR, StadiumCarFeeONE, StadiumCarMININTONE, StadiumCarMAXINTONE);
        carInStadiumParkingFee.add(parkingFeeStadiumCarOne);

        Integer StadiumCarFeeTwo = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE"));
        Integer StadiumCarMININTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarTwo = new ParkingFee(VehicleType.CAR, StadiumCarFeeTwo, StadiumCarMININTTWO, StadiumCarMAXINTTWO);
        carInStadiumParkingFee.add(parkingFeeStadiumCarTwo);

        Integer StadiumCarFeeThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE"));
        Integer StadiumCarMININTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarThree = new ParkingFee(VehicleType.CAR, StadiumCarFeeThree, StadiumCarMININTThree, StadiumCarMAXINTThree);
        carInStadiumParkingFee.add(parkingFeeStadiumCarThree);
        return carInStadiumParkingFee;
    }

    private List<ParkingFee> BikeInStadiumFee() {
        List<ParkingFee> bikeInStadiumParkingFeeList = new ArrayList<>();
        Integer StadiumBikeFeeONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE"));
        Integer StadiumBikeMININTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeOne = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeONE, StadiumBikeMININTONE, StadiumBikeMAXINTONE);
        bikeInStadiumParkingFeeList.add(parkingFeeStadiumBikeOne);

        Integer StadiumBikeFeeTwo = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE"));
        Integer StadiumBikeMININTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeTwo = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeTwo, StadiumBikeMININTTWO, StadiumBikeMAXINTTWO);
        bikeInStadiumParkingFeeList.add(parkingFeeStadiumBikeTwo);

        Integer StadiumBikeFeeThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE"));
        Integer StadiumBikeMININTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeThree = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeThree, StadiumBikeMININTThree, StadiumBikeMAXINTThree);
        bikeInStadiumParkingFeeList.add(parkingFeeStadiumBikeThree);
        return bikeInStadiumParkingFeeList;
    }
}
