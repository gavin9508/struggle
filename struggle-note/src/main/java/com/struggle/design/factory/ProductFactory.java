package com.struggle.design.factory;

/**
 * @Author sly
 * @Date 2022/7/20 23:29
 * @Description 创建工厂ProductFactory，根据参数创建指定产品对象
 */
public class ProductFactory{
    //根据用户的需求创建不同的产品
    public static Product getBean(String name){
        if(name.equals("mobile")){
            return new Mobile();
        }else if(name.equals("car")){
            return new Car();
        }
        return null;
    }

    public static  <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
       try {
           product = (Product)Class.forName(c.getName()).newInstance();
       }catch (Exception e){
           System.out.println("产品产生错误");
       }
        return (T)product;
    }
}
