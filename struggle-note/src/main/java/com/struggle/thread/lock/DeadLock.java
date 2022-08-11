package com.struggle.thread.lock;

import com.struggle.thread.ThreadUtil;

public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread myThread = new Thread(new MyThread(o1, o2));
        Thread myThread2 = new Thread(new MyThread2(o1, o2));

        myThread.start();
        myThread2.start();

        try {
            myThread.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main");
    }
}

class MyThread implements Runnable {
    private Object o1;
    private Object o2;

    public MyThread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1) {//若MyThread抢占到CPU时间片，可能执行完后，MyThread2才执行，这就不会有死锁出现
            ThreadUtil.sleep(1);//等待一下以保证MyThread2拿到o2的锁
            synchronized (o2) {
            }
        }
    }
}

class MyThread2 implements Runnable {
    private Object o1;
    private Object o2;

    public MyThread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2) {//若MyThread2抢占到CPU时间片，可能执行完后，MyThread才执行，这就不会有死锁出现
            ThreadUtil.sleep(1);//等待一下以保证MyThread拿到o1的锁
            synchronized (o1) {
            }
        }
    }
}
