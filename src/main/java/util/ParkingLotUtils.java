package util;

public class ParkingLotUtils {

    public static double compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
    {
        double milliseconds1 = oldTime.getTime();
        double milliseconds2 = currentTime.getTime();
        double diff = milliseconds2 - milliseconds1;
        return diff / (60 * 1000);
    }
}
