package DTO;

import Config.FeeModel;
import enums.ParkingLocation;
import enums.VehicleType;
import lombok.Data;
import util.ParkingLotUtils;

import java.sql.Timestamp;


/**
 * ParkingReceipt DTO/Model class
 */
@Data
public class ParkingReceipt {
    private Integer receiptNumber;
    private ParkingTicket parkingTicket;
    private Timestamp exitDateTime;
    private Double fees;

    @Override
    public String toString() {
        return "Parking Receipt:" +
                "Receipt Number:" + receiptNumber +
                ", Entry Date-time:" + parkingTicket.getEntryDateTime() +
                ", Exit Date-time: " + exitDateTime +
                ", fees: " + fees +
                '}';
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
                return Math.ceil(differenceInHour) * FeeModel.MallBikeFee;
            }

            if (vehicleType.equals(VehicleType.CAR)) {
                return Math.ceil(differenceInHour) * FeeModel.MallCarFee;
            }

            if (vehicleType.equals(VehicleType.TRUCK)) {
                return Math.ceil(differenceInHour) * FeeModel.MallTruckFee;
            }
        }

//STADIUM
        if (parkingLocation.equals(ParkingLocation.STADIUM)) {
            if (vehicleType.equals(VehicleType.BIKE)) {
                if (FeeModel.StadiumBikeFeeONE <= differenceInHour && differenceInHour < FeeModel.StadiumBikeMAXINTONE) {
                    amount = FeeModel.StadiumBikeFeeONE;
                }
                if (FeeModel.StadiumBikeMININTTWO <= differenceInHour && differenceInHour < FeeModel.StadiumBikeMAXINTTWO) {
                    amount = FeeModel.StadiumBikeFeeONE + FeeModel.StadiumBikeFeeTwo;
                }
                if (FeeModel.StadiumBikeMININTThree <= differenceInHour) {
                    amount += FeeModel.StadiumBikeFeeONE + FeeModel.StadiumBikeFeeTwo +
                            FeeModel.StadiumBikeFeeThree * Math.ceil(differenceInHour - FeeModel.StadiumBikeMAXINTTWO);
                }
                return amount;
            }
            if (vehicleType.equals(VehicleType.CAR)) {
                if (FeeModel.StadiumCarMININTONE <= differenceInHour && differenceInHour < FeeModel.StadiumCarMAXINTONE) {
                    amount = FeeModel.StadiumCarFeeONE;
                }
                if (FeeModel.StadiumCarMININTTWO <= differenceInHour && differenceInHour < FeeModel.StadiumCarMAXINTTWO) {
                    amount = FeeModel.StadiumCarFeeONE + FeeModel.StadiumCarFeeTwo;

                }
                if (FeeModel.StadiumCarMININTThree <= differenceInHour) {
                    amount += FeeModel.StadiumCarFeeONE + FeeModel.StadiumCarFeeTwo +
                            FeeModel.StadiumBikeFeeThree * Math.ceil(differenceInHour - FeeModel.StadiumCarMAXINTTWO);
                }
                return amount;
            }
        }

//AIRPORT
        if (parkingLocation.equals(ParkingLocation.AIRPORT)) {
            if (vehicleType.equals(VehicleType.BIKE)) {
                if (FeeModel.AirportBikeMININTONE <= differenceInHour && differenceInHour < FeeModel.AirportBikeMAXINTONE) {
                    amount = FeeModel.AirportBikeFeeONE;
                    return amount;
                }
                if (FeeModel.AirportBikeMININTTWO <= differenceInHour && differenceInHour < FeeModel.AirportBikeMAXINTTWO) {
                    amount = FeeModel.AirportBikeFeeTwo;
                    return amount;
                }
                if (FeeModel.AirportBikeMININTThree <= differenceInHour && differenceInHour < FeeModel.AirportBikeMAXINTThree) {
                    amount = FeeModel.AirportBikeFeeThree;
                    return amount;
                }
                if (differenceInHour >= FeeModel.AirportBikeMAXINTThree) {
                    amount = FeeModel.AirportBikeFeePerDay * Math.ceil(differenceInHour / 24);
                    return amount;
                }

            }

            if (vehicleType.equals(VehicleType.CAR)) {
                if (FeeModel.AirportCarMININTONE <= differenceInHour && differenceInHour < FeeModel.AirportCarMAXINTONE) {
                    amount = FeeModel.AirportCarFeeONE;
                }
                if (FeeModel.AirportCarMININTTWO <= differenceInHour && differenceInHour < FeeModel.AirportCarMAXINTTWO) {
                    amount = FeeModel.AirportCarFeeTwo;

                }
                if (differenceInHour >= FeeModel.AirportCarMAXINTTWO) {
                    amount = FeeModel.AirportCarFeePerDay * Math.ceil(differenceInHour / 24);
                }
                return amount;
            }
        }

        return amount;
    }

}
