package com.struggle.base.javaBase.reflects;

import com.struggle.base.javaBase.domain.UserA;

import java.lang.reflect.Constructor;

/**
 * Class.forName()会发生什么？
 * 这个方法的执行会导致类加载，类加载时，静态代码块执行
 **/
public class ReflectTest02_forName {
    public static void main(String[] args) throws Exception {

        //将User.class文件装载到JVM中的过程。
        Class<?> aClass = Class.forName("com.domain.UserA");//Class.forName()这个方法会导致：类加载。
        Class.forName("com.domain.UserA");

        UserA u = (UserA) aClass.newInstance();//通过反射机制创建对象

        Class<?> bClass = Class.forName("com.domain.UserB");
        Constructor<?> constructor = bClass.getDeclaredConstructor(String.class);
        constructor.newInstance("张三");
    }
}

