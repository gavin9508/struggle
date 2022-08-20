package com.struggle.base.javaBase.reflects.properties;

import com.struggle.base.javaBase.FileUtil;

import java.io.FileReader;
import java.util.Properties;

/**
 * 读取properties文件
 **/
public class PropertiesTest01 {
    public static void main(String[] args) throws Exception {
        String path = FileUtil.getPathByClass("com/struggle/base/javaBase/reflects/classInfo.properties");

        Properties p = new Properties();//1.创建属性对象
        FileReader fr = new FileReader(path);//2.创建流
        p.load(fr);//3.加载
        fr.close();//4.关闭流

        String className = p.getProperty("className");//通过key获取value
        System.out.println(className);

        Class c = Class.forName(className);//通过反射机制创建对象
        Object o = c.newInstance();//创建对象
        System.out.println(o);

    }
}