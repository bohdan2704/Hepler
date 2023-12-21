package org.example.back;

import java.time.LocalTime;

public class Timing {

    public static String start() {
        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Extract hour, minute, and second
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();

        return hour + "_" + minute + "_" + second;
    }
}
