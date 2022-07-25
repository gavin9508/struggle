package com.struggle.design.factory.abstracts;

/**
 * 抽象产品工厂
 */
public interface IproductFactory {
    IphoneProduct iphoneProduct();

    IRouterProduct irouterProduct();
}
