package com.struggle.base.reflection;

/**
 * @Author sly
 * @Date 2022/7/27 21:07
 * @Description 反射被测试的实体类
 */
public class Robot {
    //私有属性
    private String name;

    //公有方法
    public void sayHi(String hello) {
        System.out.println(hello + " " + name);
    }

    //私有方法
    private String throwHello(String tag) {
        return "hello " + tag;
    }
}
