package Config;

import enums.VehicleType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class VehicleCapacity {
    FileReader reader;
    Properties p = new Properties();

    public VehicleCapacity() throws IOException {
        reader = new FileReader("vehiclecapacity.properties");
        p.load(reader);
    }

    public Integer getVehicleCapacity(VehicleType vehicleType)  {
        switch (vehicleType) {
            case BIKE:
                return Integer.valueOf(p.getProperty("BIKE"));
            case CAR:
                return Integer.valueOf(p.getProperty("CAR"));
            case TRUCK:
                return Integer.valueOf(p.getProperty("TRUCK"));
        }
        return null;
    }

}
