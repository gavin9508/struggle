package com.struggle.design.builder.demo3;

/**
 * @Author sly
 * @Date 2022/7/29 22:14
 * @Description 宝马模型代码
 */
public class BMWModel extends CarModel {
    protected void alarm() {
        System.out.println("宝马车的喇叭声音是这个样子的...");
    }
    protected void engineBoom() {
        System.out.println("宝马车的引擎是这个声音的...");
    }
    protected void start() {
        System.out.println("宝马车跑起来是这个样子的...");
    }
    protected void stop() {
        System.out.println("宝马车应该这样停车...");
    }
}
