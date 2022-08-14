package com.struggle.thread.wait_notify;

import com.struggle.thread.ThreadUtil;

/**
 * @author: wkl
 * @create: 2022-08-14 00:05
 **/
public class C_01_SynWaitDemo {
    static Integer index = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                index++;
                synchronized (index) {
                    if (index > 10) {
                        ThreadUtil.wait(index);
                    }
                    ThreadUtil.log("hello --> {}", index);
                }
            }
        });
        t1.setName("t1");
        t1.start();

        while (t1.isAlive()) {
            if (t1.getState().toString().equals("WAITING")) {
                ThreadUtil.log(t1.getState());
                break;
            }
        }
    }
}
