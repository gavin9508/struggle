package com.struggle.design.observer;

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 监听对象 -实现方法睡觉
 */
public class SleepInfo extends AbstractInfo{
    @Override
    void message() {
        System.out.println("该休息了，亲！");
    }
}
