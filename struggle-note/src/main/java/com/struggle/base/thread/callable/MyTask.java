package com.struggle.base.thread.callable;

import com.struggle.base.thread.ThreadUtil;

import java.util.concurrent.Callable;

public class MyTask implements Callable {
    @Override
    public Object call() throws Exception {
        //线程执行，执行之后可能会有一个结果
        System.out.println("call method begin");
        ThreadUtil.sleepSecond(5);
        System.out.println("call method end");
        return "hello, result!";
    }
}
