package DTO;

import enums.ParkingLocation;

import java.sql.Timestamp;

public class ParkingTicket {
    private Integer ticketNumber;
    private final Timestamp entryDateTime;
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

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public ParkingLocation getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(ParkingLocation parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public Timestamp getEntryDateTime() {
        return entryDateTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
