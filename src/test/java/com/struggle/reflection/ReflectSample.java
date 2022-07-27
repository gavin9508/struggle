package com.struggle.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author sly
 * @Date 2022/7/27 21:07
 * @Description 反射应用类
 */
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, InvocationTargetException {
        //加载类
        Class<?> rc = Class.forName("com.struggle.reflection.Robot");
        //获取类实例
        Robot r = (Robot)rc.newInstance();
        //打印类名
        System.out.println(rc.getName());

        //加载一个私有方法
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        //针对私有的属性和方法必须设置setAccessible(true)才能进行访问
        getHello.setAccessible(true);
        Object bob = getHello.invoke(r, "bob");
        System.out.println(bob);

        //加载一个公有方法
        Method sayHi = rc.getMethod("sayHi",String.class);
        //此时私有属性还未赋值
        Object welcome = sayHi.invoke(r,"welcome");

        //加载一个私有属性
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        //设置对应的属性值
        name.set(r,"tom");
        //获取对应的属性值
        System.out.println(name.get(r));
        sayHi.invoke(r,"welcome");
    }
}
