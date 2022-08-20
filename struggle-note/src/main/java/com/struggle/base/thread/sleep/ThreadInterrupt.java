package com.struggle.base.thread.sleep;


import com.struggle.base.thread.ThreadUtil;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            ThreadUtil.sleep(1000 * 60 * 60 * 24 * 356);
        });
        thread.start();

        ThreadUtil.sleep(1000 * 5);

        //终端thread线程的休眠（这种终端休眠的方式依靠了java的异常处理机制）
        thread.interrupt();

    }
}
