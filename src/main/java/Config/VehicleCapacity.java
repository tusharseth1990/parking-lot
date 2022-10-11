package Config;


import constant.ParkingLotConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * VehicleCapacity config class to read vehiclecapacity.properties
 */
public  class VehicleCapacity {

    public static Integer BIKE;
    public static Integer CAR;
    public static Integer TRUCK;

    static {
        Properties p = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader(ParkingLotConstants.VEHICLECAPACITY_PROPERTIES);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            p.load(reader);
            BIKE = Integer.valueOf(p.getProperty("BIKE"));
            CAR = Integer.valueOf(p.getProperty("CAR"));
            TRUCK = Integer.valueOf(p.getProperty("TRUCK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
