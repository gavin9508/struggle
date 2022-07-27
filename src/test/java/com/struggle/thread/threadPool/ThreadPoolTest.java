package com.struggle.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author gavin
 * @Date 2022/7/27 22:10
 * 线程池示例
 */
public class ThreadPoolTest {
    public static void main(String[] args)  {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        Executors.newFixedThreadPool(1);
    }
}
