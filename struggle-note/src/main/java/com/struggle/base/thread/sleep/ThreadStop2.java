package com.struggle.base.thread.sleep;

import com.struggle.base.thread.ThreadUtil;

/**
 * 怎么合理的终止一个线程
 */
public class ThreadStop2 {
    static boolean isRun = true;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                if (isRun) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    ThreadUtil.sleepSecond(1);
                } else {
                    System.out.println("终止当前线程" + "-->" + i);
                    return;
                }
            }
        });
        thread.start();

        ThreadUtil.sleepSecond(5);
        isRun = false;
    }
}
