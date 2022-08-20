package com.struggle.base.thread.sleep;

import com.struggle.base.thread.ThreadUtil;

/**
 * 在java中怎么强制终止一个线程的执行
 * thread.stop();
 * 这种方式容易丢数据，因为这种方式是直接将线程杀死
 * 线程没有保存的数据将会丢失，不建议使用。
 */
public class ThreadStop {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            ThreadUtil.sleep(1000 * 60 * 60 * 24 * 356);
        });
        thread.start();

        ThreadUtil.sleep(1000 * 5);

        //已过时，不建议使用
        thread.stop();

    }
}
