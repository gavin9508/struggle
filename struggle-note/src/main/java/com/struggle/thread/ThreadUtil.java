package com.struggle.thread;

public class ThreadUtil {
    /**
     * @param millis
     * @毫秒
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param second
     * @秒
     */
    public static void sleepSecond(int second) {
        sleep(second * 1000);
    }

    /**
     * @param minute
     * @分
     */
    public static void sleepMinute(int minute) {
        sleepSecond(minute * 60);
    }

    /**
     * @param hour
     * @小时
     */
    public static void sleepHour(int hour) {
        sleepMinute(hour * 60);
    }

    /**
     * @param day
     * @天
     */
    public static void sleepDay(int day) {
        sleepHour(day * 24);
    }

    /**
     * @param week
     * @周
     */
    public static void sleepWeek(int week) {
        sleepDay(week * 7);
    }
}
