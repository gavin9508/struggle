package com.struggle.javaBase.reflects;

import java.lang.reflect.Field;

/*
java.lang.reflect.Field; 获取某个指定的属性
 */
public class ReflectTest05 {
    public static void main(String[] args) throws Exception {
        //以前的方式：
		/*
		User u = new User();
		u.age = 12; //set
		System.out.println(u.age); //get
		*/

        Class<?> c = Class.forName("com.struggle.javaBase.domain.User");//获取类
        Field idField = c.getDeclaredField("id");//获取id属性
        Object userObj = c.newInstance();//获取到某个特定的属性可以用来？set , get
        //打破封装
        idField.setAccessible(true);//使用反射机制可以打破封装性，会导致java对象的属性不安全。
        //set
        idField.set(userObj, "0001");//给userObj对象的id属性赋值"0001"
        System.out.println(idField.get(userObj));//get
    }
}