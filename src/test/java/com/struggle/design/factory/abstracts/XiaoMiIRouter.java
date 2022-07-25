package com.struggle.design.factory.abstracts;

public class XiaoMiIRouter implements IRouterProduct {
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openWifi() {
        System.out.println("打开小米WIFI");
    }

    @Override
    public void setting() {
        System.out.println("设置小米路由器");
    }

}
