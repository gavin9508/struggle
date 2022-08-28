package com.struggle.base.thread.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int index = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        int num = 100;
        List<Thread> threads = new ArrayList<Thread>(num);
        long start = System.currentTimeMillis();
        for (int j = 0; j < num; j++) {//创建100个线程
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.start();//启动线程
        }
        // 等待所有线程执行完成
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cas.index);
        System.out.println(cas.atomicI.get());
        System.out.println((System.currentTimeMillis() - start) + "ms");
    }

    /**
     * 使用CAS实现线程安全计数器
     */
    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            //比较并交换
            //unsafe.compareAndSwapInt(this, valueOffset, expect, update);
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count() {
        index++;
    }

}
