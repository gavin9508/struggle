package com.struggle.base.thread.threadDemo;

import com.struggle.base.thread.ThreadUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer(true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date firstDate = sdf.parse("2022-08-11 23:24:00 000");//任务启动时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String date = sdf.format(new Date());
                System.out.println(date + "：执行了一次定时任务");
            }
        }, firstDate, 1000);
        ThreadUtil.sleepMinute(1);
        timer.cancel();
    }
}
