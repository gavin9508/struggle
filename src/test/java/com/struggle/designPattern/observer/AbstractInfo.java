package com.struggle.designPattern.observer;

public abstract class AbstractInfo {
    //被监听的对象
    private Clock clock;
    abstract void message();
}
