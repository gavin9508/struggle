package com.struggle.design.proxy.dynamicProxy;

/**
 * @Author sly
 * @Date 2022/7/22 17:11
 * @Description 目标对象
 */

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}