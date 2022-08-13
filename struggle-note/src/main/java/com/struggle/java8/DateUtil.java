package com.struggle.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author: wkl
 * @create: 2022-08-13 18:28
 * @description: LocalDate 日期  LocalDate date = LocalDate.of(2022, 8, 1)指定日期2022-08-01
 * LocalTime 时间
 * LocalDateTime 日期和时间 LocalDateTime dateTime = date.atTime(18, 1, 1)指定时间2022-08-01T18:01:01
 * Clock 时钟
 * Instant
 */
public class DateUtil {

    /**
     * @description: 获取当前日期字符串
     * @author: wkl
     * @return: java.lang.String
     **/
    public static String getNowDateStr() {
        LocalDate now = LocalDate.now();
        return now.toString();
    }

    /**
     * @description: 获取年份
     * @author: wkl
     * @return: int
     **/
    public static int getYear() {
        return LocalDate.now().getYear();
    }

    /**
     * @description: 获取月份
     * @author: wkl
     * @return: int
     **/
    public static int getMonth() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * @description: 获取当前时间字符串
     * @author: wkl
     * @return: java.lang.String
     **/
    public static String getNowTimeStr() {
        return LocalTime.now().toString();
    }

    /**
     * @description: 获取当前日期后某周的时间
     * @author: wkl
     * @param: num
     * @return: java.time.LocalDate
     **/
    public static LocalDate getDateAfterWeek(int num) {
        return LocalDate.now().plus(num, ChronoUnit.WEEKS);
    }

    /**
     * @description: 获取当前日期后某天、某周、某月、某年的时间
     * @author: wkl
     * @param: num
     * @param: chrono
     * @return: java.time.LocalDate
     **/
    public static LocalDate getDateAfter(int num, ChronoUnit chrono) {
        return LocalDate.now().plus(num, chrono);
    }

    /**
     * @description: 获取当前日期前某天、某周、某月、某年的时间
     * @author: wkl
     * @param: num
     * @param: chrono
     * @return: java.time.LocalDate
     **/
    public static LocalDate getDateBefore(int num, ChronoUnit chrono) {
        return LocalDate.now().minus(num, chrono);
    }

    /**
     * @description: 获取当前时间前某天、某周、某月、某年、某时、某分、某秒的时间
     * @author: wkl
     * @param: num
     * @param: chrono
     * @return: java.time.LocalDateTime
     **/
    public static LocalDateTime getDateTimeBefore(int num, ChronoUnit chrono) {
        return LocalDateTime.now().minus(num, chrono);
    }

    /**
     * @description: 获取当前时间后某天、某周、某月、某年、某时、某分、某秒的时间
     * @author: wkl
     * @param: num
     * @param: chrono
     * @return: java.time.LocalDateTime
     **/
    public static LocalDateTime getDateTimeAfter(int num, ChronoUnit chrono) {
        return LocalDateTime.now().plus(num, chrono);
    }

    /**
     * @description: 获取时间戳，根据系统时钟返回当前时间，并设置为UTC(世界标准时间)
     * @author: wkl
     * @return: long
     **/
    public static long getTimeStampUTF() {
        Clock clock = Clock.systemUTC();
        return clock.millis();
    }

    /**
     * @description: 获取时间戳，返回基于系统时钟区域的时间
     * @author: wkl
     * @return: long
     **/
    public static long getTimeStampZone() {
        Clock clock = Clock.systemDefaultZone();
        return clock.millis();
    }

    /**
     * @description: 获取时间戳，返回基于系统时钟区域的时间
     * 实际上 Instant 类确实等同于 Java 8 之前的 Date 类，你可以使用 Date 类和 Instant 类各自的转换方法互相转换
     * Date.from(Instant) 将 Instant 转换成 java.util.Date，Date.toInstant() 则是将 Date 类转换成 Instant 类
     * @author: wkl
     * @return: long
     **/
    public static long getTimeStamp() {
        Instant timestamp = Instant.now();
        return timestamp.toEpochMilli();
    }

    /**
     * @description: 是否闰年
     * @author: wkl
     * @return: boolean
     **/
    public static boolean isLeapYear() {
        LocalDate today = LocalDate.now();
        return today.isLeapYear();
    }

    /**
     * @description: 是否闰年
     * @author: wkl
     * @param: year
     * @return: boolean
     **/
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, 1, 1).isLeapYear();
    }

    /**
     * @description: 当前时间转对应字符串
     * @author: wkl
     * @return: java.lang.String
     **/
    public static String getTimeStr() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        return date.format(dtf);
    }

    /**
     * @description: 当前时间转对应字符串
     * @author: wkl
     * @param: date
     * @return: java.lang.String
     **/
    public static String getTimeStr(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        return date.format(dtf);
    }

    /**
     * @description: 当前时间转对应字符串
     * @author: wkl
     * @param: pattern
     * @return: java.lang.String
     **/
    public static String getTimeStr(String pattern) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return date.format(dtf);
    }

    /**
     * @description: 当前时间转对应字符串
     * @author: wkl
     * @param: date
     * @param: pattern
     * @return: java.lang.String
     **/
    public static String getTimeStr(LocalDateTime date, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return date.format(dtf);
    }

    /**
     * @description: 时间字符串转日期
     * @author: wkl
     * @param: timeStr
     * @return: java.time.LocalDate
     **/
    public static LocalDate strToDate(String timeStr) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
        return LocalDate.parse(timeStr, dtf);
    }

    /**
     * @description: 时间字符串转日期
     * @author: wkl
     * @param: timeStr
     * @param: pattern
     * @return: java.time.LocalDate
     **/
    public static LocalDate strToDate(String timeStr, String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(timeStr, dtf);
    }

    /**
     * @description: 获取两时间之间的时间差（毫秒）
     * @author: wkl
     * @param: nowTime
     * @param: targetTime
     * @return: int
     **/
    public static long getMillisBetweenTimes(LocalDateTime time, LocalDateTime time2) {
        return Duration.between(time, time2).toMillis();
    }

    public static void main(String[] args) {
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }

}
