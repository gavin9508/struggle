package com.struggle.javaBase.reflects.properties;

import com.struggle.javaBase.FileUtil;

import java.io.InputStream;
import java.util.Properties;

/**
 * 通过流读取读取properties文件
 **/
public class PropertiesTest02 {
    public static void main(String[] args) throws Exception {
        InputStream ins = FileUtil.getInsByClassLoader("com/struggle/javaBase/reflects/classInfo.properties");

        Properties p = new Properties();//1.创建属性对象
        p.load(ins);//2.加载流
        ins.close();//3.关闭流

        String className = p.getProperty("className");//通过key获取value
        System.out.println(className);

        Class c = Class.forName(className);//通过反射机制创建对象
        Object o = c.newInstance();//创建对象
        System.out.println(o);

    }
}