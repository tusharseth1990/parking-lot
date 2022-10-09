package DTO;

import enums.ParkingLocation;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class ParkingTicket {
    private Integer ticketNumber;
    private Timestamp entryDateTime;
    private ParkingSpot parkingSpot;
    private ParkingLocation parkingLocation;

    public ParkingTicket(Integer ticketNumber, Timestamp entryDateTime, ParkingSpot parkingSpot, ParkingLocation parkingLocation) {
        this.ticketNumber = ticketNumber;
        this.entryDateTime = entryDateTime;
        this.parkingSpot = parkingSpot;
        this.parkingLocation = parkingLocation;
    }

    @Override
    public String toString() {
        return "Parking Ticket: " +
                "Ticket Number:" + ticketNumber +
                ", Spot Number:" + parkingSpot +
             ", Entry Date-time:" + entryDateTime ;
    }

}
