package com.struggle.design.factory;

/**
 * @Author sly
 * @Date 2022/7/20 23:39
 * @Description 工厂模式测试类--产品工厂
 */
public class ProductFactoryTest {
    public static void main(String[] args) {
        Product mobile = ProductFactory.getBean("mobile");
        Product car = ProductFactory.getBean("car");
        mobile.show();
        car.show();
    }
}
