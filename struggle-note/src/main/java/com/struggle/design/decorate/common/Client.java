package com.struggle.design.decorate.common;

/**
 * @Author sly
 * @Date 2022/7/28 16:11
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
         //修饰后运行
        component.operate();
    }
}