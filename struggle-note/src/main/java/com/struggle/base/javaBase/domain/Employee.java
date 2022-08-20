package com.struggle.base.javaBase.domain;

public class Employee {
    //Field
    private String name;

    //Constructor
    public Employee() {
        System.out.println("Employee的无参数构造方法执行");
    }

    public Employee(String name) {
        this.name = name;
    }

    //方法
    public void work() {
        System.out.println(name + "在工作！");
    }

}