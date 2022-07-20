package com.struggle.design.factory;

/**
 * @Author sly
 * @Date 2022/7/20 23:26
 * @Description 产品实现类--手机产品详情
 */
public class Mobile implements Product{

    @Override
    public void show() {
        System.out.println("手机：HUAWEI P40 Pro +");
    }
}
