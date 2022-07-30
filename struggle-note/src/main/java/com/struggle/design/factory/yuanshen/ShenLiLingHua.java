package com.struggle.design.factory.yuanshen;

/**
 * @Author sly
 * @Date 2022/7/27 10:14
 * @Description
 */
public class ShenLiLingHua implements Ice{
    @Override
    public void name() {
        System.out.println("姓名：神里凌华");
    }

    @Override
    public void sex() {
        System.out.println("性别：女");
    }

    @Override
    public void grade() {
        System.out.println("等级：40级");
    }
}
