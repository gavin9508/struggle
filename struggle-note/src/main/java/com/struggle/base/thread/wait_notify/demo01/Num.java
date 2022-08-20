package com.struggle.base.thread.wait_notify.demo01;

//共享数据
class Num {
    int count;

    Num(int count) {
        this.count = count;
    }

    //打印奇数的方法
	/*
		t1线程执行该方法，拿走num对象的对象锁，并且输出 t1-->1,唤醒t2线程，
		虽然t2线程被唤醒，t2线程并不会马上执行，因为t2线程无法获取到对象锁。
		当printOdd方法执行this.wait(), t1线程无期限的等待，printOdd方法结束，释放对象锁，
		t2线程获取到对象锁，开始执行printEven方法.
	*/
    public synchronized void printOdd() {
        System.out.println(Thread.currentThread().getName() + "--->" + (count++));
        this.notifyAll();
        try {
            Thread.sleep(1000);
            this.wait();//t1线程无期限的等待.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //打印偶数的方法
    public synchronized void printEven() {
        System.out.println(Thread.currentThread().getName() + "--->" + (count++));
        this.notifyAll();
        try {
            Thread.sleep(1000);
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
