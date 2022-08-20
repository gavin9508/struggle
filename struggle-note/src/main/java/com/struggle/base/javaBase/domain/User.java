package com.struggle.base.javaBase.domain;

public class User {
    //Field
    private String id;
    public int age;
    protected String addr;
    boolean sex;

    public User() {
    }

    public User(String id, int age, String addr, boolean sex) {
        this.id = id;
        this.age = age;
        this.addr = addr;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }

    public boolean isSex() {
        return sex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
