package com.struggle.design.observer;

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 监听者抽象类接口
 */
public abstract class AbstractInfo {
    //被监听的对象
    private Clock clock;
    abstract void message();
}
