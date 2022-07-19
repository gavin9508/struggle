package com.struggle.designPattern.observer;

public class SleepInfo extends AbstractInfo{
    @Override
    void message() {
        System.out.println("该休息了，亲！");
    }
}
