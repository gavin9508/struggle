package com.struggle.base.thread.callable;

import com.struggle.base.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * FutureTask
 * 第四种方式：FutureTask + ExecutorService
 */
public class CallableDemo04 {
    public static void main(String[] args) {
        //1.创建一个未来任务类对象
        FutureTask futureTask = new FutureTask(new MyTask());

        //2.启动
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(futureTask);
        executorService.shutdown();//关闭线程池，停止接收新任务，原来的任务继续执行

        //怎么获取thread线程返回值？
        /**
         * futureTask.get()
         * get()方法可能需要很久，因为get()方法是为了拿另一个线程的执行结果，另一个线程执行是需要时间的
         */
        String result = ThreadUtil.getResult(futureTask, String.class);
        System.out.println(result);
        ThreadUtil.sleepSecond(2);
        System.out.println("hello world!");
    }
}
