package com.struggle.java8;

/**
 * @Author sly
 * @Date 2022/8/9 22:08
 * @Description
 */

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class TestLocalDateTime {
    // LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1() {
        Date date = new Date();
        System.out.println(date);
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime localDateTime = LocalDateTime.of(2015, 03, 10, 13, 04, 34);
        System.out.println(localDateTime);
        System.out.println(localDateTime.plusDays(2));
        System.out.println(localDateTime.getYear());
    }

    // Instant：时间戳(以Unix元年：1970年1月1日 00:00:00到某个之间的毫秒值)
    @Test
    public void test2() {
        Instant ins = Instant.now();
        System.out.println(ins);
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        System.out.println(ins.toEpochMilli());
        Instant instant = Instant.ofEpochSecond(1);
        System.out.println(instant);
    }

    // Duration：计算两个"时间"之间的间隔
    // Period：计算两个"日期"之间的间隔
    @Test
    public void test3() {
        Instant ins = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration duration = Duration.between(ins, ins2);
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMillis());
        System.out.println("--------");

        LocalTime lt = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt2 = LocalTime.now();
        Duration duration2 = Duration.between(lt, lt2);
        System.out.println(duration2);
    }

    // 时间校正器
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt1 = ldt.withDayOfMonth(10);
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt2);

        // 自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    // DateTimeFormatter: 格式化时间/日期
    @Test
    public void test5() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = ldt.format(dtf);
        System.out.println(format);
        String format1 = ldt.format(dtf1);
        System.out.println(format1);

        System.out.println("-----------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = dtf2.format(ldt);
        System.out.println(strDate);
        System.out.println("-------");
//        LocalDateTime newDate = ldt.parse(strDate, dtf2);
//        System.out.println(newDate);
    }

}
