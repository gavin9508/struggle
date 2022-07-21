package com.struggle.design.singleton;

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 单例实现1--饿汉模式
 */
public class HungrySingleModel {
    //整个应用只有一个自己的实例---初始化时候创建，不管会不会使用，此方法会浪费内存
    private static HungrySingleModel instance = new HungrySingleModel();

    //只能自己创建自己
    private HungrySingleModel() {
    }

    //需要提供一个方法让外界访问自己
    public static HungrySingleModel getInstance() {
        return instance;
    }
}

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 单例实现2--懒汉模式
 */
class LazySingleModel {
    //整个应用只有一个自己的实例---判断对象是否存在，没有在创建对象（此方法不是线程安全的）
    private static LazySingleModel instance;//不直接实例化

    //只能自己创建自己
    private LazySingleModel() {
    }

    //需要提供一个方法让外界访问自己
    public static LazySingleModel getInstance() {
        //instance为空的时候才创建，在多线程的情况下这里是线程不安全的
        if (instance == null) {
            instance = new LazySingleModel();
        }
        return instance;
    }
}

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 单例实现3--双重检验锁
 */
//双重检验锁
class DoubleTestSingleModel {
    //整个应用只有自己一个实例
    private volatile DoubleTestSingleModel instance;

    //只能自己创建自己
    private DoubleTestSingleModel() {
    }

    //提供一个外界能访问的方法
    public DoubleTestSingleModel getInstance(){
        if(instance == null){
            //如果instance为空则创建对象
            synchronized (DoubleTestSingleModel.class){
                if(instance == null){
                    this.instance = new DoubleTestSingleModel();
                }
            }
        }
        return instance;
    }
}

