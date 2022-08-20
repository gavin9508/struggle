package com.struggle.base.thread.threadDemo;

import com.struggle.base.thread.ThreadUtil;

/**
 * 守护线程
 * 用户线程
 * 用户线程在则必要守护，用户线程不在则没必要守护了
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {//即使是死循环，但由于该线程是守护线程，当用户线程结束，守护线程自动结束。
                System.out.println(ThreadUtil.getName() + " --> " + (i++));
                ThreadUtil.sleepSecond(1);
            }
        });
        thread.setName("测试线程");
        thread.setDaemon(true);//设置为守护线程
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadUtil.getName() + " --> " + i);
            ThreadUtil.sleepSecond(1);
        }
    }
}
