package com.struggle.base.javaBase.domain;

public class UserB {

    private String name;

    public static int a = 100;

    public UserB(String name) {
        this.name = name;
        System.out.println("UserB的有参数构造方法执行，姓名为：" + name);
    }

    static {
        //静态代码块在类加载的时执行，并且只执行一次
        System.out.println("UserB的静态代码块");
    }

}
