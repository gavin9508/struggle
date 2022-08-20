package com.struggle.base.javaBase.reflects;

import com.struggle.base.javaBase.domain.Employee;

import java.util.Date;

/**
 * 获取Class类型对象的三种方式
 * 第一种：Class c = Class.forName("完整类名带包名");
 * 第二种：Class c = 对象.getClass();
 * 第三种：Class c = 任何类型.class
 * 三种方式加载类的时机不同
 **/
public class ReflectTest01 {
    public static void main(String[] args) throws Exception {

        //第一种方式：
        Class c1 = Class.forName("com.domain.Employee"); //c1引用保存内存地址指向堆中的对象，该对象代表的是Employee整个类.

        //第二种方式：
        //java中每个类型都有 class 属性.
        Class c2 = Employee.class;

        //第三种方式：
        //java语言中任何一个java对象都有 getClass 方法
        Employee e = new Employee();
        Class c3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee)

        //因为Employee这个类在JVM中只有一个，所以c1,c2,c3的内存地址是相同的，指向堆中唯一的一个对象.
        System.out.println(c1 == c2); //true
        System.out.println(c2 == c3); //true


        //c4,c5,c6都代表 Date这个类
        Class c4 = Date.class; //c4代表 Date这个类

        Class c5 = Class.forName("java.util.Date"); //必须写类全名，类全名带有包名.

        Date d = new Date();
        Class c6 = d.getClass();

        System.out.println(c4 == c5); //true
        System.out.println(c5 == c6); //true

        //c7代表 int 类型
        Class c7 = int.class;

    }
}

