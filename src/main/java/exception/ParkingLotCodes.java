package exception;

public enum ParkingLotCodes {
    PARKING_SPOT_FULL("Parking spot is already full"),
    PARKING_VEHICLE_LOCATION("Parking vehicle or location is invalid"),
    PARKING_TICKET_INVALID("Parking Ticket is invalid");
    private final String messageFormat;

    ParkingLotCodes(String messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
