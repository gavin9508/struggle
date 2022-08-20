package com.struggle.base.javaBase.domain;

public class Customer {
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Customer[" + name + "," + age + "]";
    }
}
