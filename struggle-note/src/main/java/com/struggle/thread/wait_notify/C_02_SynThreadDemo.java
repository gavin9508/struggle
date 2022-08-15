package com.struggle.thread.wait_notify;

import com.struggle.thread.ThreadUtil;

/**
 * @author: wkl
 * @create: 2022-08-14 00:34
 * @description: 当线程终止时，会调用线程自身的notifyAll()方法，会通知所有等待在该线程对象上的线程。
 * 所以尽量不要使用线程对象做同步锁
 **/
public class C_02_SynThreadDemo {
    public static void main(String[] args) {
        Thread parser1 = new Thread(() -> {
            ThreadUtil.log("线程开始执行");
            ThreadUtil.sleep(5000);
            ThreadUtil.log("线程执行结束，结束后会调用线程自身的notifyAll()方法");
        });

        Thread parser2 = new Thread(() -> {
            synchronized (parser1) {
                while (true) {
                    ThreadUtil.log("线程进入等待");//t1线程结束后会调用自身的notifyAll()方法，唤醒t2，t2再次执行等待进入WAITING状态
                    try {
                        parser1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        parser1.setName("t1");
        parser2.setName("t2");
        parser1.start();
        parser2.start();

        ThreadUtil.log("现在存活线程数：{}", Thread.activeCount());
        try {
            parser1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadUtil.log("现在存活线程数：{}", Thread.activeCount());
    }
}
