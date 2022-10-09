package util;

public class ParkingLotUtils {

    public static double compareTwoTimeStamps(java.sql.Timestamp currentTime, java.sql.Timestamp oldTime)
    {
        double milliseconds1 = oldTime.getTime();
        double milliseconds2 = currentTime.getTime();

        double diff = milliseconds2 - milliseconds1;
        double diffSeconds = diff / 1000;
        double diffMinutes = diff / (60 * 1000);
        double diffHours = diff / (60 * 60 * 1000);
        double diffDays = diff / (24 * 60 * 60 * 1000);

        return diffMinutes;
    }
}
