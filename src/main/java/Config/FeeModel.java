package Config;

import constant.ParkingLotConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * FeeModel: Config class
 */
public class FeeModel {

    public static Integer MallBikeFee;
    public static Integer MallCarFee;
    public static Integer MallTruckFee;

    public static Integer AirportCarFeeONE;
    public static Integer AirportCarMININTONE;
    public static Integer AirportCarMAXINTONE;
    public static Integer AirportCarFeeTwo;
    public static Integer AirportCarMININTTWO;
    public static Integer AirportCarMAXINTTWO;
    public static Integer AirportCarFeePerDay;
    public static Integer AirportBikeFeeONE;
    public static Integer AirportBikeMININTONE;
    public static Integer AirportBikeMAXINTONE;
    public static Integer AirportBikeFeeTwo;
    public static Integer AirportBikeMININTTWO;
    public static Integer AirportBikeMAXINTTWO;
    public static Integer AirportBikeFeeThree;
    public static Integer AirportBikeMININTThree;
    public static Integer AirportBikeMAXINTThree;
    public static Integer AirportBikeFeePerDay;

    public static Integer StadiumCarFeeONE;
    public static Integer StadiumCarMININTONE;
    public static Integer StadiumCarMAXINTONE;
    public static Integer StadiumCarFeeTwo;
    public static Integer StadiumCarMININTTWO;
    public static Integer StadiumCarMAXINTTWO;
    public static Integer StadiumCarFeeThree;
    public static Integer StadiumCarMININTThree;
    public static Integer StadiumBikeFeeONE;
    public static Integer StadiumBikeMININTONE;
    public static Integer StadiumBikeMAXINTONE;
    public static Integer StadiumBikeFeeTwo;
    public static Integer StadiumBikeMININTTWO;
    public static Integer StadiumBikeMAXINTTWO;
    public static Integer StadiumBikeFeeThree;
    public static Integer StadiumBikeMININTThree;

    static {
        Properties p = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader(ParkingLotConstants.FEEMODELS_PROPERTIES);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(reader);
            MallBikeFee = Integer.valueOf(p.getProperty(ParkingLotConstants.MALL_BIKE));
            MallCarFee = Integer.valueOf(p.getProperty(ParkingLotConstants.MALL_CAR));
            MallTruckFee = Integer.valueOf(p.getProperty(ParkingLotConstants.MALL_TRUCK));

            AirportCarFeeONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_ONE_PRICE));
            AirportCarMININTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_ONE_PRICE_MIN_INTERVAL));
            AirportCarMAXINTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_ONE_PRICE_MAX_INTERVAL));
            AirportCarFeeTwo = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_TWO_PRICE));
            AirportCarMININTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_TWO_PRICE_MIN_INTERVAL));
            AirportCarMAXINTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_TWO_PRICE_MAX_INTERVAL));
            AirportCarFeeTwo = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_TWO_PRICE));
            AirportCarFeePerDay = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_CAR_INTERVAL_PER_DAY));
            AirportBikeFeeONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_ONE_PRICE));
            AirportBikeMININTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_ONE_PRICE_MIN_INTERVAL));
            AirportBikeMAXINTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_ONE_PRICE_MAX_INTERVAL));
            AirportBikeMAXINTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_ONE_PRICE_MAX_INTERVAL));
            AirportBikeFeeTwo = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_TWO_PRICE));
            AirportBikeMININTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_TWO_PRICE_MIN_INTERVAL));
            AirportBikeMAXINTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_TWO_PRICE_MAX_INTERVAL));
            AirportBikeFeeThree = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_THREE_PRICE));
            AirportBikeMININTThree = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_THREE_PRICE_MIN_INTERVAL));
            AirportBikeMAXINTThree = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_THREE_PRICE_MAX_INTERVAL));
            AirportBikeFeePerDay = Integer.valueOf(p.getProperty(ParkingLotConstants.AIRPORT_BIKE_INTERVAL_PER_DAY));

            StadiumCarFeeONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_ONE_PRICE));
            StadiumCarMININTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_ONE_PRICE_MIN_INTERVAL));
            StadiumCarMAXINTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_ONE_PRICE_MAX_INTERVAL));
            StadiumCarFeeTwo = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_TWO_PRICE));
            StadiumCarMININTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_TWO_PRICE_MIN_INTERVAL));
            StadiumCarMAXINTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_TWO_PRICE_MAX_INTERVAL));
            StadiumCarFeeThree = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_THREE_PRICE));
            StadiumCarMININTThree = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_CAR_INTERVAL_THREE_PRICE_MIN_INTERVAL));
            StadiumBikeFeeONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_ONE_PRICE));
            StadiumBikeMININTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_ONE_PRICE_MIN_INTERVAL));
            StadiumBikeMAXINTONE = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_ONE_PRICE_MAX_INTERVAL));
            StadiumBikeFeeTwo = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_TWO_PRICE));
            StadiumBikeMININTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_TWO_PRICE_MIN_INTERVAL));
            StadiumBikeMAXINTTWO = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_TWO_PRICE_MAX_INTERVAL));
            StadiumBikeFeeThree = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_THREE_PRICE));
            StadiumBikeMININTThree = Integer.valueOf(p.getProperty(ParkingLotConstants.STADIUM_BIKE_INTERVAL_THREE_PRICE_MIN_INTERVAL));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
