package util;

/**
 * ParkingLotUtils a utility class
 */
public class ParkingLotUtils {
    /**
     * Basically used for Comparing two timestamps
     * @param currentTime current timestamp
     * @param oldTime old timestamp
     * @return return double value of time difference
     */
    public static double compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
    {
        double milliseconds1 = oldTime.getTime();
        double milliseconds2 = currentTime.getTime();
        double diff = milliseconds2 - milliseconds1;
        return diff / (60 * 1000);
    }
}
