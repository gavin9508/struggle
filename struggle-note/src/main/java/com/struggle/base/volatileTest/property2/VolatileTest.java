package com.struggle.base.volatileTest.property2;

/**
 * @Author gavin
 * @Date 2022/7/19 0:07
 *  volatile 内存可见性
 */
public class VolatileTest {
    public static volatile int i = 0;
    // 共享变量状态置为false
    boolean status = false;
    // 解决可见性问题，只需将共享变量加以volatile关键字修饰
    // volatile boolean status = false;

    /**
     * 状态切换为true
     */
    public void changeStatus() {
        status = true;
    }

    /**
     * 若状态为true，则running。
     */
    public void run() {
        if (status) {
            //synchronized (this){
            System.out.println("run...");
            i++;
            //}
        }
    }

    public static void main(String[] args)  {
        //TODO 代码复现比较复杂
        // 假设A执行了changeStatus方法后，这个时候线程B运行了run方法，这个时候控制台并不会打印run...，
        // 注意前提为多线程环境，正因为是在多线程的环境下，线程A对共享变量status状态切换为true，
        // 对于线程B来说是不可见的，因此System.out.println("run...")并不一定会执行。
        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i <= 1000; i++) {

            new Thread(() -> {
                volatileTest.changeStatus();
            },"A").start();

            new Thread(() -> {
                volatileTest.run();
            },"B").start();
        }
        System.out.println(i);
        //TODO 所谓内存可见性，指的是当一个线程对volatile修饰的变量进行写操作时，JMM会立即把该线程对应的本地内存中的共享变量的值刷新到主内存；
        // 当一个线程对volatile修饰的变量进行读操作时，JMM会把立即该线程对应的本地内存置为无效，从主内存中读取共享变量的值。
    }


}