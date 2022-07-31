package com.struggle.thread.wait_notify;

/*
	两个线程对1个共享的数据操作。

	t1和t2两个线程对同一个num操作。
	t1输出1，t1唤醒其他线程,t1等待.
	t2输出2，t2唤醒其他线程,t2等待.
*/
public class Test {
    public static void main(String[] args) throws Exception {

        Num num = new Num(1);

        Thread t1 = new Thread(new PrintOdd(num));
        t1.setName("t1");
        Thread t2 = new Thread(new PrintEven(num));
        t2.setName("t2");

        t1.start();

        Thread.sleep(1000);

        t2.start();
    }
}




