package com.struggle.thread.countDownLatch;

import com.struggle.thread.ThreadUtil;

/**
 * join用于让当前执行线程等待join线程执行结束。其实现原理是不停检查join线程是否存活，
 * 如果join线程存活则让当前线程永远等待。其中，wait（0）表示永远等待下去，代码片段如下
 * while (isAlive()) {
 * wait(0);
 * }
 * <p>
 * wait和sleep 区别?（面试题)
 * 相同点:
 * 1.wait和 sleep都是让线程进入休眠状态。
 * 2.wait和 sleep在执行的过程中都可以接收到终止线程执行的通知。
 * 不同点
 * 1. wait 使用必须配合synchronized一起使用，而sleep 不用。
 * 2. wait会释放锁，而sleep 不会释放锁。
 * 3. wait 是 Object（对象） 的方法，而 sleep 是 Thread（线程）的方法。
 * 4. 默认情况下 wait（不传递任何参数或者是参数为0的情况下）它会进入 waiting 状态，而 sleep 会进入 timed_waiting 状态。
 * 5. 使用 wait 时可以主动的唤醒线程，而使用sleep 时不能主动唤醒线程。
 */
public class C_01_JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(() -> {
            System.out.println("parser1 start");
            ThreadUtil.sleep(5000);
            System.out.println("parser1 finish");
        });
        Object obj = new Object();
        Thread parser2 = new Thread(() -> {
            synchronized (parser1) {
                while (parser1.isAlive()) {
                    System.out.println("parser2 wait");
                    try {
                        parser1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("parser2 finish");
        });
        parser1.setName("t1");
        parser2.setName("t2");
        parser1.start();
        parser2.start();

        while (parser1.isAlive()) {
            ThreadUtil.log("parser2的运行状态：{}", parser2.getState());
            if ("WAITING".endsWith(parser2.getState().toString())) {
                ThreadUtil.log("parser2的运行状态：{}", parser2.getState());
                ThreadUtil.log("parser1 {}", parser1);
                break;
            }
        }
//        parser1.join();
//        parser2.join();
//        Thread.currentThread().getThreadGroup().list();
        synchronized (parser1) {
            while (parser1.isAlive()) {
                System.out.println("main-parser1 wait");
                parser1.wait(0);//main线程阻塞，wait(0)等于无限阻塞，sleep不释放锁，而wait释放锁
                //若是不wait()，则锁不释放，此处无限循环
            }
        }
        synchronized (parser2) {
            while (parser2.isAlive()) {
                System.out.println("main-parser2 wait");
                parser2.wait(0);
            }
        }

        System.out.println("all parser finish");
        ThreadUtil.log("parser1 {}", parser1);
        System.out.println(Thread.activeCount());
    }
}
