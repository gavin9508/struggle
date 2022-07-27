package com.struggle.design.factory.yuanshen;

/**
 * @Author sly
 * @Date 2022/7/27 10:17
 * @Description
 */
public class ChongYun implements Ice{
    @Override
    public void name() {
        System.out.println("姓名：重云");
    }

    @Override
    public void sex() {
        System.out.println("性别：男");
    }

    @Override
    public void grade() {
        System.out.println("等级：50级");
    }
}
