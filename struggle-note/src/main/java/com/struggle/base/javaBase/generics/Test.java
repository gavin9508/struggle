package com.struggle.base.javaBase.generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // 范围较广
    static void countLegs(List<? extends Animal> animals) {
    }

    // 范围定死
    static void countLegs1(List<Animal> animals) {
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs(dogs);
        // 报错
//        countLegs1(dogs);// Required type: List<Animal>   Provided: List<Dog>
    }
}
