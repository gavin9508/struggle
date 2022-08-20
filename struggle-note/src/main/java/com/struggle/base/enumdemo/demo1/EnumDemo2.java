package com.struggle.base.enumdemo.demo1;

/**
 * @Author sly
 * @Date 2022/8/14 21:12
 * @Description
 */
public enum EnumDemo2 implements food, sport {
    FOOD,
    SPORT,
    ; //分号分隔

    @Override
    public void eat() {
        System.out.println("eat.....");
    }

    @Override
    public void run() {
        System.out.println("run.....");
    }
}

