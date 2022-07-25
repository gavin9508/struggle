package com.struggle.design.factory.simple;

public class Test {
    public static void main(String[] args) {
//        Car wuLing = new WuLing();
//        Car tesla = new Tesla();
//        wuLing.name();
//        tesla.name();

        CarFactory.getCar("五菱").name();
        CarFactory.getCar("特斯拉").name();
    }
}
