package com.struggle.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    /**
     * @param futureTask
     * @param clazz<T>   表示限制参数类型为T
     * @param <T> T      <T>表示是泛型，T表示返回的是T类型的数据
     * @return
     * @获取callable的结果
     * @泛型： ？表示不确定的 java 类型
     * T (type) 表示具体的一个java类型
     * K V (key value) 分别代表java键值中的Key Value
     * E (element) 代表Element
     * < T > 等同于 < T extends Object>
     * < ? > 等同于 < ? extends Object>
     */
    public static <T> T getResult(FutureTask futureTask, Class<T> clazz) {
        Object obj = null;
        try {
            obj = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return clazz.cast(obj);
    }
}
