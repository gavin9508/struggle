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

        //测试反射实现的工厂处理
        Mobile mobile1 = ProductFactory.createProduct(Mobile.class);
        mobile1.show();
        Car car2 = ProductFactory.createProduct(Car.class);
        car2.show();
    }
}
