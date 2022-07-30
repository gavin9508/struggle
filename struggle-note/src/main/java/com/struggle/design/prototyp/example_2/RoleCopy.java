package com.struggle.design.prototyp.example_2;

/**
 * @Author sly
 * @Date 2022/7/30 22:48
 * @Description 抽象角色对象
 */
public interface RoleCopy extends Cloneable {
    /**
     * 克隆方法
     * @return roleCopy 对象
     */
    public RoleCopy clone();

    /**
     * 打印信息
     */
    public void display();
}