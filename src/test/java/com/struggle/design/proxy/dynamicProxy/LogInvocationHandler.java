package com.struggle.design.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author gavin
 * @Date 2022/7/26 23:08
 * 日志代理
 */
public class LogInvocationHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行方法： " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("方法执行完毕： " + method.getName());
        return result;
    }
}
