package com.struggle.design.decorate;

/**
 * @Author gavin
 * @Date 2022/7/25 22:04
 */
public class XiaoQiao implements Hero{


    @Override
    public String name() {
        return "小乔";
    }

    @Override
    public int baseDamage() {
        return 400;
    }
}
