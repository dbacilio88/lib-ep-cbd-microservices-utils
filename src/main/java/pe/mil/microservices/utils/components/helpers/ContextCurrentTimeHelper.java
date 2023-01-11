package pe.mil.microservices.utils.components.helpers;

import java.sql.Timestamp;

public class ContextCurrentTimeHelper {

    public static Timestamp getTimestamp(long time) {
        return new Timestamp(time);
    }

    public static long getStarTime() {
        return System.currentTimeMillis();
    }

    public static long getTotalTime(long starTime) {
        return System.currentTimeMillis() - starTime;
    }
}