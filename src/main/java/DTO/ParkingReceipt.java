package DTO;

import java.sql.Timestamp;

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

    public ParkingReceipt(Integer receiptNumber, ParkingTicket parkingTicket, Timestamp exitDateTime, Double fees) {
        this.receiptNumber = receiptNumber;
        this.parkingTicket = parkingTicket;
        this.exitDateTime = exitDateTime;
        this.fees = fees;
    }

    public ParkingReceipt() {
    }

    public Integer getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(Integer receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public Timestamp getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(Timestamp exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    private Double calcParkingFees(){
        return 0.0;
    }

}
