package com.struggle.base.javaBase.reflects;

import com.struggle.base.javaBase.domain.UserA;
import com.struggle.base.javaBase.domain.UserB;

import java.lang.reflect.Constructor;

/**
 * UserA.class会发生什么？
 * newInstance();通过反射创建对象时加载类
 **/
public class ReflectTest02_class {
    public static void main(String[] args) throws Exception {

        //不会执行静态语句块
        Class aClass = UserA.class;

        Class bClass = UserB.class;
//        bClass.newInstance();

        //获取带参数的构造器
        Constructor<UserB> constructor = bClass.getDeclaredConstructor(String.class);
        UserB userB = constructor.newInstance("张三");//通过反射机制创建对象
    }
}

