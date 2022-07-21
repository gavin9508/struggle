package com.struggle.design.factory;

/**
 * @Author sly
 * @Date 2022/7/20 23:28
 * @Description 产品实现类--汽车产品详情
 */
public class Car implements Product{
    @Override
    public void show() {
        System.out.println("汽车：比亚迪！");
    }
}
