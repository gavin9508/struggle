package com.struggle.object.classCheck;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author gavin
 * @version 1.0
 * @date 2022/7/20 下午4:45
 * @Description 类加载机制
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int value1;
    public static int value2 = 2;


    static {
        System.out.println("静态代码块-value2：" + value2);
    }

    {
        System.out.println("构造代码块-value2：" + value2);
    }

    private Singleton() {
        System.out.println("构造");
        value1++;
        value2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        //TODO 根据现象来看先加载类， 而类中static成员是按顺序的
        Singleton singleton = Singleton.singleton;
        new Singleton();
        System.out.println("Singleton1 value1:" + Singleton.singleton.value1);
        System.out.println("Singleton1 value2:" + Singleton.singleton.value2);
    }

}
