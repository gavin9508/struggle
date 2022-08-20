package com.struggle.base.javaBase.reflects;

public class CustomerService {
    //登录
    public boolean login(String name, String pwd) {

        if ("admin".equals(name) && "123".equals(pwd)) {
            return true;
        }

        return false;
    }

    //退出
    public void logout() {
        System.out.println("系统已安全退出！");
    }
}