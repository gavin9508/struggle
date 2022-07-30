package com.struggle.volatileTest.property1;

import java.util.concurrent.CountDownLatch;


/**
 * volatile 原子性问题分析  结论：volatile不能保证原子性
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        //volatile关键字，保证了可见性，但没有保证原子性
        TestThread thread = new TestThread(countDownLatch);
        for(int i=0;i<10;i++){
            new Thread(thread).start();
        }

        //保证10个线程执行完毕，再打印最终结果
        countDownLatch.await();

        //TODO(疑问) 正常执行结果应该是10000，但几乎每次运行结果都小于这个数
        System.out.println(thread.i);
        //TODO(答疑) 假设某一时刻i=10，线程A读取10到自己的工作内存，A对该值进行加一操作，但正准备将11赋给i时，
        // 由于此时i的值并未改变，B读取了主存的值仍为10到自己的工作内存，并执行了加一操作，正准备将11赋给i时，
        // A将11赋给了i，由于volatile的影响，立即同步到主存，主存中的值为11，并使得B工作内存中的i失效，B执行第三步，
        // 虽然此时B工作内存中的i失效了，但是第三步是将11赋给i，对B来说，我只是赋值操作，并没有使用i这个动作，
        // 所以这一步并不会去刷新主存，B将11赋值给i，并立即同步到主存，主存中的值仍为11。虽然A/B都执行了加一操作，
        // 但主存却为11，这就是最终结果不是10000的原因。
    }
}
