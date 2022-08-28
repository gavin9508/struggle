package com.struggle.base.thread.callable;


import com.struggle.base.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future
 * 第三种方式：Future + ExecutorService
 */
public class CallableDemo03 {
    public static void main(String[] args) {
        //1.创建一个Callable接口对象
        MyTask myTask = new MyTask();

        //2.启动
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(myTask);
        executorService.shutdown();

        //怎么获取thread线程返回值？
        /**
         * futureTask.get()
         * get()方法可能需要很久，因为get()方法是为了拿另一个线程的执行结果，另一个线程执行是需要时间的
         */
        String result = ThreadUtil.getResult(future, String.class);
        System.out.println(result);
        ThreadUtil.sleepSecond(2);
        System.out.println("hello world!");
    }
}
