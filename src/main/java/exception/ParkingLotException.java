package exception;

import lombok.Getter;
import lombok.ToString;

/**
 * ParkingLotException: Base Exception class
 */
@ToString
@Getter
public class ParkingLotException extends RuntimeException{
    final String code;
    final String displayMessage;

    public ParkingLotException(String code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
    }

}
