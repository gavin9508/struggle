package com.struggle.design.proxy.dynamicProxy;

/**
 * @Author sly
 * @Date 2022/7/22 17:19
 * @Description
 */
public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao();//目标对象
        System.out.println(target.getClass());
        //代理对象
        IUserDao proxy = (IUserDao) new
                ProxyFactory(target).getProxyInstance();
        proxy.save();

        System.out.println("=============================================");
        //获取日志代理对象
        IUserDao logProxy = (IUserDao) ProxyFactory.getLogProxy(target);
        logProxy.save("获得万天帝一只");
    }
}
