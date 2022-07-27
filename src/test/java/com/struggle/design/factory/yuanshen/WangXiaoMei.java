package com.struggle.design.factory.yuanshen;

/**
 * @Author sly
 * @Date 2022/7/27 10:03
 * @Description
 */
public class WangXiaoMei implements Ice{
    @Override
    public void name() {
        System.out.println("姓名：王小美");
    }

    @Override
    public void sex() {
        System.out.println("性别：女");
    }

    @Override
    public void grade() {
        System.out.println("等级：90级");
    }
}
