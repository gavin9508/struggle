package com.struggle.design.prototyp.example_1;

/**
 * @Author sly
 * @Date 2022/7/30 23:31
 * @Description 深拷贝测试
 */

public class Client {

    public static void main(String[] args)  throws Exception {
        DeepProtoType p = new DeepProtoType(); p.name = "胡桃";
        p.deepCloneableTarget = new DeepCloneableTarget("甘雨", "王小美");

        //方式 1  完成深拷贝
        DeepProtoType p2 = (DeepProtoType) p.clone();

        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());

        //方式 2  完成深拷贝
        DeepProtoType p3 = (DeepProtoType) p.deepClone();

        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
        System.out.println("p.name=" + p.name + "p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode());

    }
}

