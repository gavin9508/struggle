package com.struggle.thread.wait_notify.demo01;

public class PrintEven implements Runnable {
    Num num;

    PrintEven(Num num) {
        this.num = num;
    }

    public void run() {

        while (true) {
            //打印偶数
            num.printEven();
        }

    }
}
