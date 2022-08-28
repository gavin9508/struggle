package com.struggle.base.thread;

import com.struggle.base.java8.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    public static String getName() {
        return Thread.currentThread().getName();
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String yyyyMMddHHmmssSSS() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return sdf.format(new Date());
    }

    public static Date dateParse(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date = null;
        try {
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @param futureTask
     * @param clazz<T>   表示限制参数类型为T
     * @param <T>        表示是泛型，T表示返回的是T类型的数据
     * @return
     * @获取callable的结果 泛型：
     * ？表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     * < T > 等同于 < T extends Object>
     * < ? > 等同于 < ? extends Object>
     */
    public static <T> T getResult(Future future, Class<T> clazz) {
        Object obj = null;
        try {
            obj = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return clazz.cast(obj);
    }

    public static void log(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.getTimeStr()).append(" ").append("[").append(ThreadUtil.getName()).append("] --> ");
        sb.append(obj);
        System.out.println(sb.toString());
    }

    public static void log(String format, Object... argArray) {
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.getTimeStr()).append(" ").append("[").append(ThreadUtil.getName()).append("] --> ");
        if (argArray == null) {
            sb.append(format);
            System.out.println(sb.toString());
        } else {
            format = format.trim();
            String[] formatArr = format.split("\\{\\}");
            if (format.endsWith("{}")) {
                if (formatArr.length == 0) {
                    formatArr = new String[1];
                    formatArr[0] = "";
                } else if (formatArr.length != argArray.length) {
                    throw new RuntimeException("format中的{}与传入参数数量不一致");
                }
            } else if (formatArr.length != argArray.length + 1) {
                throw new RuntimeException("format中的{}与传入参数数量不一致");
            }
            for (int i = 0; i < argArray.length; i++) {
                sb.append(formatArr[i]).append(argArray[i]);
            }

            if (formatArr.length == argArray.length + 1) {
                sb.append(formatArr[formatArr.length - 1]);
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        log("hello 1{} 2{} 3{}", "a", "b", "c");
        Object obj = new Object();
        ThreadUtil.log("生产了：{}", obj);
        String format = "已生产：{} 等待消费";
        log("已生产：{} 等待消费", obj);
        ThreadUtil.log("{}", obj);
    }
}
