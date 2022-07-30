package com.struggle.thread.threadPool;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author gavin
 * @Date 2022/7/27 22:10
 * 线程池示例
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //TODO 线程池流程测试  调整参数进行测试
        //    corePoolSize: 核心线程数为 5。
        //    maximumPoolSize ：最大线程数 10
        //    keepAliveTime : 等待时间为 1L。
        //    unit: 等待时间的单位为 TimeUnit.SECONDS。
        //    workQueue：任务队列为 ArrayBlockingQueue，并且容量为 100;
        //    handler:饱和策略为 CallerRunsPolicy。
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, 10, 1L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new Thread("线程：" + i) {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
                }
            };
            //执行Runnable
            threadPoolExecutor.execute(worker);
        }
        //终止线程池
        threadPoolExecutor.shutdown();

        System.out.println("======================================");
        Executors.newFixedThreadPool(5);
        System.out.println("newFixedThreadPool:只能创建核心线程");
         Executors.newCachedThreadPool();
        System.out.println("newCachedThreadPool:只能创建非核心线程");
         Executors.newSingleThreadExecutor();
        System.out.println("newSingleThreadExecutor:有且仅有一个核心线程");
        Executors.newScheduledThreadPool(5);
        System.out.println("newScheduledThreadPool:，支持定时及周期性任务执行。 ");
    }
}
