package com.struggle.exception.test;

/**
 * @Author gavin
 * @Date 2022/8/13 22:21
 */
public class MyInput implements AutoCloseable {

    MyInput() {
        System.out.println("创建一个我自己的资源");
    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭自己的资源");
    }
}
