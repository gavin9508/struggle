package com.struggle.thread.getName;

import com.struggle.thread.ThreadUtil;

/**
 * Thread.currentThread表示当前代码段正在被哪个线程调用
 *
 */
public class MyThread extends Thread {
    public MyThread() {
        // main方法创建线程，线程在初始化对象的时候， this代表的当前对象MyThread，
        // 然后Thread在初始化对象的时候，会给线程起一个默认的初始名，所以this.getname()打印出来是“当前线程的名字：Thread-0”。
        System.out.println("当前线程的名字：" + Thread.currentThread().getName() + "   run==" + Thread.currentThread().isAlive());
        System.out.println("当前线程的名字：" + this.getName() + "   run==" + this.isAlive());
        System.out.println("当前线程的名字：" + super.getName() + "   run==" + super.isAlive());
    }

    @Override
    public void run() {
        System.out.println("当前线程的名字：" + Thread.currentThread().getName() + "   run==" + Thread.currentThread().isAlive());
        System.out.println("当前线程的名字：" + this.getName() + "  run==" + this.isAlive());
        System.out.println("当前线程的名字：" + super.getName() + "  run==" + super.isAlive());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadUtil.sleep(2000);
        myThread.setName("t1");
        System.out.println("---------------------t1 start()-----------------------");
        myThread.start();

        ThreadUtil.sleep(2000);
        //此时myThread作为参数传入Thread中，其实是myThread委托thread去执行；
        Thread thread = new Thread(myThread);
        //初始化自定义线程名称
        thread.setName("t2");
        System.out.println("---------------------t2 start()-----------------------");
        //启动线程
        thread.start();

    }
}



