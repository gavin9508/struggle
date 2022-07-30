package com.struggle.design.proxy.staticProxy;

/**
 * @Author sly
 * @Date 2022/7/22 17:12
 * @Description
 */
public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao(); //多态目标对象
        IUserDao proxy = new UserDaoProxy(target);//代理对象
        target.save();
        System.out.println("==============");
        proxy.save();
    }
}