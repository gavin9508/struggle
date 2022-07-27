package com.struggle.design.factory.yuanshen;

import java.util.ArrayList;

/**
 * @Author sly
 * @Date 2022/7/27 10:20
 * @Description
 */
public class IceFactory {
    //方法一：需要提供多个创建对象的方式
    public WangXiaoMei getWangXiaoMei() {
        return new WangXiaoMei();
    }

    public DiAoNa getDiAoNa() {
        return new DiAoNa();
    }

    public ChongYun getChongYun() {
        return new ChongYun();
    }

    public ShenLiLingHua getShenLiLingHua() {
        return new ShenLiLingHua();
    }


    //方法二：利用反射1
    public Ice getIceByClassKey(String className){
        try{
            return (Ice) Class.forName(className).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    //反射2
        public static  <T>T getInstance(String className,Class<T> tClass) throws
            Exception {
        T instance = null;
        instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        return instance;
    }
}
