package com.struggle.design.proxy.staticProxy;

/**
 * @Author sly
 * @Date 2022/7/22 17:12
 * @Description
 */
//代理对象
public class UserDaoProxy implements IUserDao {
    private IUserDao target;//null 目标对象

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
