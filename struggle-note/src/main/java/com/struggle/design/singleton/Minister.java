package com.struggle.design.singleton;

/**
 * @Author sly
 * @Date 2022/7/24 0:29
 * @Description
 */
public class Minister {
    public static void main(String[] args) {
        //定义5个大臣
        int ministerNum = 5;
        for (int i = 0; i < ministerNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是：");
            emperor.say();
        }
    }
}
