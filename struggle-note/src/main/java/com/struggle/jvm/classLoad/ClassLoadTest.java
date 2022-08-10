package com.struggle.jvm.classLoad;

/**
 * @Author gavin
 * @Date 2022/7/26 22:18
 * 类加载器
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println("ClassLoadTest 类加载器："+classLoader);
        ClassLoader parent = ClassLoadTest.class.getClassLoader().getParent();
        System.out.println("ClassLoadTest 父类加载器："+parent);
        ClassLoader parent1 = ClassLoadTest.class.getClassLoader().getParent().getParent();
        System.out.println("ClassLoadTest 父类加载器的父类："+parent1);
    }
}
