package com.struggle.object.classLoad;

/**
 * @Author gavin
 * @Date 2022/7/26 22:18
 * 类加载器
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = ClassLoadTest.class.getClassLoader().getParent();
        System.out.println(parent);
        ClassLoader parent1 = ClassLoadTest.class.getClassLoader().getParent().getParent();
        System.out.println(parent1);
    }
}
