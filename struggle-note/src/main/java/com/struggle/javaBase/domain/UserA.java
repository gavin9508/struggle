package com.struggle.javaBase.domain;

public class UserA {

    public UserA() {
        System.out.println("UserA的无参数构造方法执行");
    }

    static {
        //静态代码块在类加载的时执行，并且只执行一次
        System.out.println("UserA的静态代码块");
    }

}
