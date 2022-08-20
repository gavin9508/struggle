package com.struggle.base.java8.stream;

/**
 * @Author sly
 * @Date 2022/8/7 0:25
 * @Description
 */
public class Type {
    String name;

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                '}';
    }
}
