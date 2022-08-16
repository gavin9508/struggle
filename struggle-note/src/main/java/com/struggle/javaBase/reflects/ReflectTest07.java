package com.struggle.javaBase.reflects;
/*
	获取某个特定的方法，通过反射机制执行。

	以前：
	CustomerService cs = new CustomerService();
	boolean isSuccess = cs.login("admin","123");

	通过反射机制？？？

*/

import java.lang.reflect.Method;

public class ReflectTest07 {
    public static void main(String[] args) throws Exception {

        //1.获取类
        Class c = Class.forName("com.struggle.javaBase.reflects.CustomerService");

        //获取某个特定的方法
        //通过：方法名+形参列表
        Method m = c.getDeclaredMethod("login", String.class, String.class);

        //通过反射机制执行login方法.
        Object o = c.newInstance();

        //调用o对象的m方法,传递"admin""123"参数，方法的执行结果是retValue
        Object retValue = m.invoke(o, "admin", "123");
        System.out.println(retValue); //true

        retValue = m.invoke(o, "admin", "456");
        System.out.println(retValue); //false

    }
}
