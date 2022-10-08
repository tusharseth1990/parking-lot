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
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        Integer MallBikeFee = Integer.valueOf(p.getProperty("MALL.BIKE"));
        ParkingFee parkingFeeBike = new ParkingFee(VehicleType.BIKE, MallBikeFee, null, null);
        parkingFeeList.add(parkingFeeBike);

        Integer MallCarFee = Integer.valueOf(p.getProperty("MALL.CAR"));
        ParkingFee parkingFeeCar = new ParkingFee(VehicleType.CAR, MallCarFee, null, null);
        parkingFeeList.add(parkingFeeCar);

        Integer MallTruckFee = Integer.valueOf(p.getProperty("MALL.TRUCK"));
        ParkingFee parkingFeeTruck = new ParkingFee(VehicleType.TRUCK, MallTruckFee, null, null);
        parkingFeeList.add(parkingFeeTruck);
        return parkingFeeList;
    }

    public List<ParkingFee> getStadiumFeeModel() {
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        BikeInStadiumFee(parkingFeeList);
        CarInStadiumFee(parkingFeeList);
        return parkingFeeList;
    }

    public List<ParkingFee> getAirportFeeModel() {
        List<ParkingFee> parkingFeeList = new ArrayList<>();
        BikeInAirportFee(parkingFeeList);
        CarInAirportFee(parkingFeeList);
        return parkingFeeList;
    }

    private void CarInAirportFee(List<ParkingFee> parkingFeeList) {
        Integer AirportCarFeeONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE"));
        Integer AirportCarMININTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer AirportCarMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportCarOne = new ParkingFee(VehicleType.CAR, AirportCarFeeONE, AirportCarMININTONE, AirportCarMAXINTONE);
        parkingFeeList.add(parkingFeeAirportCarOne);

        Integer AirportCarFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE"));
        Integer AirportCarMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer AirportCarMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportCarTwo = new ParkingFee(VehicleType.CAR, AirportCarFeeTwo, AirportCarMININTTWO, AirportCarMAXINTTWO);
        parkingFeeList.add(parkingFeeAirportCarTwo);

        Integer AirportCarFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_PER_DAY"));
        ParkingFee parkingFeeAirportCarPerDay = new ParkingFee(VehicleType.CAR, AirportCarFeePerDay, null, null);
        parkingFeeList.add(parkingFeeAirportCarPerDay);
    }

    private void BikeInAirportFee(List<ParkingFee> parkingFeeList) {
        Integer AirportBikeFeeONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE"));
        Integer AirportBikeMININTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeOne = new ParkingFee(VehicleType.BIKE, AirportBikeFeeONE, AirportBikeMININTONE, AirportBikeMAXINTONE);
        parkingFeeList.add(parkingFeeAirportBikeOne);

        Integer AirportBikeFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE"));
        Integer AirportBikeMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeTwo = new ParkingFee(VehicleType.BIKE, AirportBikeFeeTwo, AirportBikeMININTTWO, AirportBikeMAXINTTWO);
        parkingFeeList.add(parkingFeeAirportBikeTwo);

        Integer AirportBikeFeeThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE"));
        Integer AirportBikeMININTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer AirportBikeMAXINTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeAirportBikeThree = new ParkingFee(VehicleType.BIKE, AirportBikeFeeThree, AirportBikeMININTThree, AirportBikeMAXINTThree);
        parkingFeeList.add(parkingFeeAirportBikeThree);

        Integer AirportBikeFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_PER_DAY"));
        ParkingFee parkingFeeAirportBikePerDay = new ParkingFee(VehicleType.BIKE, AirportBikeFeePerDay, null, null);
        parkingFeeList.add(parkingFeeAirportBikePerDay);
    }

    private void CarInStadiumFee(List<ParkingFee> parkingFeeList) {
        Integer StadiumCarFeeONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE"));
        Integer StadiumCarMININTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarOne = new ParkingFee(VehicleType.CAR, StadiumCarFeeONE, StadiumCarMININTONE, StadiumCarMAXINTONE);
        parkingFeeList.add(parkingFeeStadiumCarOne);

        Integer StadiumCarFeeTwo = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE"));
        Integer StadiumCarMININTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarTwo = new ParkingFee(VehicleType.CAR, StadiumCarFeeTwo, StadiumCarMININTTWO, StadiumCarMAXINTTWO);
        parkingFeeList.add(parkingFeeStadiumCarTwo);

        Integer StadiumCarFeeThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE"));
        Integer StadiumCarMININTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer StadiumCarMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumCarThree = new ParkingFee(VehicleType.CAR, StadiumCarFeeThree, StadiumCarMININTThree, StadiumCarMAXINTThree);
        parkingFeeList.add(parkingFeeStadiumCarThree);
    }

    private void BikeInStadiumFee(List<ParkingFee> parkingFeeList) {
        Integer StadiumBikeFeeONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE"));
        Integer StadiumBikeMININTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeOne = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeONE, StadiumBikeMININTONE, StadiumBikeMAXINTONE);
        parkingFeeList.add(parkingFeeStadiumBikeOne);

        Integer StadiumBikeFeeTwo = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE"));
        Integer StadiumBikeMININTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeTwo = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeTwo, StadiumBikeMININTTWO, StadiumBikeMAXINTTWO);
        parkingFeeList.add(parkingFeeStadiumBikeTwo);

        Integer StadiumBikeFeeThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE"));
        Integer StadiumBikeMININTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
        Integer StadiumBikeMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
        ParkingFee parkingFeeStadiumBikeThree = new ParkingFee(VehicleType.BIKE, StadiumBikeFeeThree, StadiumBikeMININTThree, StadiumBikeMAXINTThree);
        parkingFeeList.add(parkingFeeStadiumBikeThree);
    }
}
