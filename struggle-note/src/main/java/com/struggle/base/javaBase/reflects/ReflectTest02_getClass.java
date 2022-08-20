package com.struggle.base.javaBase.reflects;

import com.struggle.base.javaBase.domain.UserA;

/**
 *
 **/
public class ReflectTest02_getClass {
    public static void main(String[] args) throws Exception {
        UserA userA = new UserA();//第一次new，因为类未加载所以会加载类，会执行静态代码块和构造函数
        userA = new UserA();//第二次new，类已加载，只会执行构造器

        Class<? extends UserA> aClass = userA.getClass();
    }
}

