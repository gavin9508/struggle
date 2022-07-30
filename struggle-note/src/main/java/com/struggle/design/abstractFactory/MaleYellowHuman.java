package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:10
 * @Description
 */
public class MaleYellowHuman extends AbstractYellowHuman{
    @Override
    public void getSex() {
        System.out.println("黄人男性");
    }
}
