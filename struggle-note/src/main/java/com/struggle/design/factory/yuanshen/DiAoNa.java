package com.struggle.design.factory.yuanshen;

/**
 * @Author sly
 * @Date 2022/7/27 10:15
 * @Description
 */
public class DiAoNa implements Ice{
    @Override
    public void name() {
        System.out.println("姓名：迪奥娜");
    }

    @Override
    public void sex() {
        System.out.println("性别：女");
    }

    @Override
    public void grade() {
        System.out.println("等级：60级");
    }
}
