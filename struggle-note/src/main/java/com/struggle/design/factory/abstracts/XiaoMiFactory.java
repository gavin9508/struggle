package com.struggle.design.factory.abstracts;

public class XiaoMiFactory implements IproductFactory {
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public IRouterProduct irouterProduct() {
        return new XiaoMiIRouter();
    }
}
