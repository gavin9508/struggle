package com.struggle.thread.wait_notify.demo01;

public class PrintOdd implements Runnable {
    Num num;

    PrintOdd(Num num) {
        this.num = num;
    }

    public void run() {

        while (true) {
            //打印奇数
            num.printOdd();
        }

    }
}