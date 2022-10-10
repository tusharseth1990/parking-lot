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
    final int httpStatus;
    final String shortCode;

    public ParkingLotException(String code, String displayMessage, int httpStatus, String shortCode) {
        this.code = code;
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
        this.shortCode = shortCode;
    }

    public ParkingLotException(String message, String code, String displayMessage, int httpStatus, String shortCode) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
        this.shortCode = shortCode;
    }

    public ParkingLotException(String message, Throwable cause, String code, String displayMessage, int httpStatus, String shortCode) {
        super(message, cause);
        this.code = code;
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
        this.shortCode = shortCode;
    }

    public ParkingLotException(Throwable cause, String code, String displayMessage, int httpStatus, String shortCode) {
        super(cause);
        this.code = code;
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
        this.shortCode = shortCode;
    }

    public ParkingLotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String displayMessage, int httpStatus, String shortCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.displayMessage = displayMessage;
        this.httpStatus = httpStatus;
        this.shortCode = shortCode;
    }
}
