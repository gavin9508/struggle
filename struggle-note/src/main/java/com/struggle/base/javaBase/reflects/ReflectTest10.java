package com.struggle.base.javaBase.reflects;

/*
	关于类获取父类和父接口
*/
public class ReflectTest10 {
    //通过反射机制获取String类的父类和父接口
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("java.util.Date");

        //获取父类
        Class superClass = c.getSuperclass();

        System.out.println("父类：" + superClass.getName());
        System.out.println("父类接口：");

        //获取父接口
        Class[] ins = c.getInterfaces();

        for (Class in : ins) {
            System.out.println(in.getName());
        }

    }
}