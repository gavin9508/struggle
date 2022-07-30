package com.struggle.design.factory.abstracts;

public class HuaWeiFactory implements IproductFactory {
    @Override
    public IphoneProduct iphoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterProduct irouterProduct() {
        return new HuaWeiIRouter();
    }
}
