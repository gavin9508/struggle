package com.struggle.javaBase;

import java.io.InputStream;

public class FileUtil {

    public static String getPathByClassLoader(String name) {
        //获取当前线程的类加载器对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //getResource();当前线程的类加载器默认从类的根路径下加载资源。
        return classLoader.getResource(name).getPath();
    }

    public static InputStream getInsByClassLoader(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }

    public static String getPathByClass(String name) {
        //获取编译后的项目根路径（class文件所在路径）
        String path = FileUtil.class.getResource("/").getPath();
        return path + name;
    }

    public static void main(String[] args) {
        String path = getPathByClassLoader("com/struggle/javaBase/reflects/classInfo.properties");
        System.out.println(path);
        path = getPathByClass("com/struggle/javaBase/reflects/classInfo.properties");
        System.out.println(path);
    }
}
