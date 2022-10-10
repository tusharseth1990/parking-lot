package Config;

import enums.VehicleType;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * VehicleCapacity config class to read vehiclecapacity.properties
 */
public class VehicleCapacity {
    FileReader reader;
    Properties p = new Properties();

    public VehicleCapacity() throws IOException {
        reader = new FileReader("vehiclecapacity.properties");
        p.load(reader);
    }

    public Integer getVehicleCapacity(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> Integer.valueOf(p.getProperty("BIKE"));
            case CAR -> Integer.valueOf(p.getProperty("CAR"));
            case TRUCK -> Integer.valueOf(p.getProperty("TRUCK"));
        };
    }

}
