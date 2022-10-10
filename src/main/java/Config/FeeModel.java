package Config;

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
    public static Integer StadiumCarMAXINTThree;
    public static Integer StadiumBikeFeeONE;
    public static Integer StadiumBikeMININTONE;
    public static Integer StadiumBikeMAXINTONE;
    public static Integer StadiumBikeFeeTwo;
    public static Integer StadiumBikeMININTTWO;
    public static Integer StadiumBikeMAXINTTWO;
    public static Integer StadiumBikeFeeThree;
    public static Integer StadiumBikeMININTThree;
    public static Integer StadiumBikeMAXINTThree;

    static {
        Properties p = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader("src/main/resources/feemodels.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(reader);
            MallBikeFee = Integer.valueOf(p.getProperty("MALL.BIKE"));
            MallCarFee = Integer.valueOf(p.getProperty("MALL.CAR"));
            MallTruckFee = Integer.valueOf(p.getProperty("MALL.TRUCK"));

            AirportCarFeeONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE"));
            AirportCarMININTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
            AirportCarMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
            AirportCarFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE"));
            AirportCarMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
            AirportCarMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
            AirportCarFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE"));
            AirportCarFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.CAR.INTERVAL_PER_DAY"));
            AirportBikeFeeONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE"));
            AirportBikeMININTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
            AirportBikeMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
            AirportBikeMAXINTONE = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
            AirportBikeFeeTwo = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE"));
            AirportBikeMININTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
            AirportBikeMAXINTTWO = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
            AirportBikeFeeThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE"));
            AirportBikeMININTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
            AirportBikeMAXINTThree = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
            AirportBikeFeePerDay = Integer.valueOf(p.getProperty("AIRPORT.BIKE.INTERVAL_PER_DAY"));

            StadiumCarFeeONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE"));
            StadiumCarMININTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
            StadiumCarMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
            StadiumCarFeeTwo = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE"));
            StadiumCarMININTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
            StadiumCarMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
            StadiumCarFeeThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE"));
            StadiumCarMININTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
//            StadiumCarMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MAX_INTERVAL"));
            StadiumBikeFeeONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE"));
            StadiumBikeMININTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL"));
            StadiumBikeMAXINTONE = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"));
            StadiumBikeFeeTwo = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE"));
            StadiumBikeMININTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL"));
            StadiumBikeMAXINTTWO = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"));
            StadiumBikeFeeThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE"));
            StadiumBikeMININTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL"));
//            StadiumBikeMAXINTThree = Integer.valueOf(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
