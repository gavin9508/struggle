package com.struggle.design.factory.method;


public class Test {
    public static void main(String[] args) {
        Car car1 = new WuLingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        car1.name();
        car2.name();

        Car car = new MoBaiFactory().getCar();
        car.name();
    }
}
