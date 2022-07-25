package com.struggle.design.factory.abstracts;

public class Test {
    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        IphoneProduct iphoneProduct = xiaoMiFactory.iphoneProduct();
        iphoneProduct.start();
        iphoneProduct.sendSMS();

        IRouterProduct iRouterProduct = xiaoMiFactory.irouterProduct();
        iRouterProduct.start();
        iRouterProduct.setting();
    }
}
