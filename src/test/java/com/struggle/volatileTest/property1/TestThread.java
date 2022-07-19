package com.struggle.volatileTest.property1;

import java.util.concurrent.CountDownLatch;

public class TestThread implements Runnable{
    //volatile不能保证原子性 atomic 美[əˈtɑ:mɪk]
    volatile int i = 0;
    CountDownLatch countDownLatch = null;
    
    public TestThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    
    @Override
    public void run() {
        for(int j=0;j<1000;j++){
            i++;
        }
        countDownLatch.countDown();
    }
}