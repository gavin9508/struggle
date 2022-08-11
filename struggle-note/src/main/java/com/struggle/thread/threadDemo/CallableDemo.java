package com.struggle.thread.threadDemo;

import com.struggle.thread.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的三种方式：
 * 1.继承java.lang.Thread类
 * 2.实现java.lang.Runnable接口
 * 3.实现java.util.concurrent.Callable接口
 */
public class CallableDemo {

    public static void main(String[] args) {
        //1.创建一个未来任务类对象
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//call()方法相当于run方法，只不过这个有返回值。
                //线程执行，执行之后可能会有一个结果
                System.out.println("call method begin");
                ThreadUtil.sleepSecond(5);
                System.out.println("call method end");
                return "hello, futureTask";
            }
        });

        //2.创建线程对象
        Thread thread = new Thread(futureTask);
        thread.start();//启动线程

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
