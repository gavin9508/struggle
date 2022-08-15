package com.struggle.enumdemo.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author sly
 * @Date 2022/8/15 21:50
 * @Description
 */
public enum SingletonEnum {
    INSTANCE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //获取枚举类的构造函数(前面的源码已分析过)
        Constructor<SingletonEnum> constructor=SingletonEnum.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        //创建枚举
        SingletonEnum singleton=constructor.newInstance("otherInstance",9);
    }
}
