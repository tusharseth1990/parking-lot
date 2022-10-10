package DTO;

import enums.ParkingLocation;
import enums.VehicleType;
import lombok.Data;
import util.ParkingLotUtils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * ParkingReceipt DTO/Model class
 */
@Data
public class ParkingReceipt {
    private Integer receiptNumber;
    private ParkingTicket parkingTicket;
    private Timestamp exitDateTime;
    private Double fees;
    Properties p = new Properties();
    FileReader reader = new FileReader("feemodels.properties");

    @Override
    public String toString() {
        return "Parking Receipt:" +
                "Receipt Number:" + receiptNumber +
                ", Entry Date-time:" + parkingTicket.getEntryDateTime() +
                ", Exit Date-time: " + exitDateTime +
                ", fees: " + fees +
                '}';
    }


    public ParkingReceipt() throws IOException {
        p.load(reader);
    }

    public Double calcParkingFees(ParkingTicket parkingTicket) {
        VehicleType vehicleType = parkingTicket.getParkingSpot().getVehicleType();
        ParkingLocation parkingLocation = parkingTicket.getParkingLocation();
        Timestamp entryDateTime = parkingTicket.getEntryDateTime();
        Timestamp exitDateTime = new Timestamp(System.currentTimeMillis());
        double differenceInMin = ParkingLotUtils.compareTwoTimeStamps(exitDateTime, entryDateTime);
        double differenceInHour = differenceInMin / 60;
        double amount = 0;
//MALL
        if (parkingLocation.equals(ParkingLocation.MALL)) {
            if (vehicleType.equals(VehicleType.BIKE)) {
                return Math.ceil(differenceInHour) * Integer.parseInt(p.getProperty("MALL.BIKE"));
            }

            if (vehicleType.equals(VehicleType.CAR)) {
                return Math.ceil(differenceInHour) * Integer.parseInt(p.getProperty("MALL.CAR"));
            }

            if (vehicleType.equals(VehicleType.TRUCK)) {
                return Math.ceil(differenceInHour) * Integer.parseInt(p.getProperty("MALL.TRUCK"));
            }

        }

//STADIUM

        if (parkingLocation.equals(ParkingLocation.STADIUM)) {
            if (vehicleType.equals(VehicleType.BIKE)) {
                if (Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE"));
                }
                if (Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE")) + Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE"));
                }
                if (Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL")) <= differenceInHour) {
                    amount += Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_ONE_PRICE")) + Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE")) +
                            Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_THREE_PRICE")) * Math.ceil(differenceInHour - Integer.parseInt(p.getProperty("STADIUM.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL")));
                }
                return amount;
            }
            if (vehicleType.equals(VehicleType.CAR)) {
                if (Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL ")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE"));
                }
                if (Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE")) + Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE"));

                }
                if (Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE.MIN_INTERVAL")) <= differenceInHour) {
                    amount += Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_ONE_PRICE")) + Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE")) +
                            Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_THREE_PRICE")) * Math.ceil(differenceInHour - Integer.parseInt(p.getProperty("STADIUM.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL")));
                }
                return amount;
            }
        }

//AIRPORT
        if (parkingLocation.equals(ParkingLocation.AIRPORT)) {
            if (vehicleType.equals(VehicleType.BIKE)) {
                if (Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_ONE_PRICE"));
                    return amount;
                }
                if (Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_TWO_PRICE"));
                    return amount;
                }
                if (Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE"));
                    return amount;
                }
                if (differenceInHour >= Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_THREE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.BIKE.INTERVAL_PER_DAY")) * Math.ceil(differenceInHour / 24);
                    return amount;
                }

            }

            if (vehicleType.equals(VehicleType.CAR)) {
                if (Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MIN_INTERVAL ")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_ONE_PRICE"));
                }
                if (Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MIN_INTERVAL")) <= differenceInHour && differenceInHour < Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE"));

                }
                if (differenceInHour >= Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_TWO_PRICE.MAX_INTERVAL"))) {
                    amount = Integer.parseInt(p.getProperty("AIRPORT.CAR.INTERVAL_PER_DAY")) * Math.ceil(differenceInHour / 24);
                }
                return amount;
            }
        }

        return amount;
    }

}
