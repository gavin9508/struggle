package com.struggle.base.thread.sleep;

import com.struggle.base.thread.ThreadUtil;

/**
 * sleep 让线程进入休眠，让出CPU时间片
 */
public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ThreadUtil.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }).start();
    }
}
