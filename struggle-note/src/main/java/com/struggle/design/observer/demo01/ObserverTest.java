package com.struggle.design.observer.demo01;

/**
 * 观察者模式（Observer Pattern）定义了对象间的一种一对多的依赖关系，这样只要一个对象的状态发生改变，其依赖的所有相关对象都会得到通知并自动更新
 * 在观察者模式中，发生改变的对象叫做观察目标，而被通知更新的对象称为观察者，
 * 一个观察目标对应多个观察者，观察者一般是一个列表集合，可以根据需要动态增加和删除，易于扩展
 * 使用观察者模式的优点在于观察目标和观察者之间是抽象松耦合关系，降低了两者之间的耦合关系
 */
public class ObserverTest {

    public static void main(String[] args) {
        // 创建一个观察目标
        JavaStackObservable javaStackObservable = new JavaStackObservable();

        // 添加观察者
        javaStackObservable.addObserver(new ReaderObserver("小明"));
        javaStackObservable.addObserver(new ReaderObserver("小张"));
        javaStackObservable.addObserver(new ReaderObserver("小爱"));

        // 发表文章
        javaStackObservable.publish("什么是观察者模式？");
    }

}

