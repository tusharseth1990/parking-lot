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

    public ParkingLotException(String message, String code, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ParkingLotException(String message, Throwable cause, String code, String displayMessage) {
        super(message, cause);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ParkingLotException(Throwable cause, String code, String displayMessage) {
        super(cause);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ParkingLotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String displayMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.displayMessage = displayMessage;
    }
}
