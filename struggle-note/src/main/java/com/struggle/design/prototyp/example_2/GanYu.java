package com.struggle.design.prototyp.example_2;

/**
 * 甘雨类
 * @Author sly
 * @Date 2022/4/22 16:48
 */
public class GanYu implements RoleCopy {
    @Override
    public RoleCopy clone() {
        RoleCopy far = null;
        try {
            far = (RoleCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
        }
        return far;
    }
    @Override
    public void display() {
        System.out.println("为了岩王帝君！");
    }
}
