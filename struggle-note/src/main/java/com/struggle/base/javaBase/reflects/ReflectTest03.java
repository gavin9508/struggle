package com.struggle.base.javaBase.reflects;
/*
	获取Class类型的对象之后，可以创建该“类”的对象
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflectTest03 {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("com.struggle.base.javaBase.domain.Employee");

        //创建此 Class 对象所表示的类的一个新实例
        Object o = c.newInstance(); //调用了Employee的无参数构造方法.

        System.out.println(o); //Employee@c17164


        Class c1 = Class.forName("java.util.Date");
        Object o1 = c1.newInstance();

        if (o1 instanceof Date) {
            Date t = (Date) o1;
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
        }

    }
}