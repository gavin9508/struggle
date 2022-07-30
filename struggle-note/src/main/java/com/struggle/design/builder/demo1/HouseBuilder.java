package com.struggle.design.builder.demo1;

/**
 * 建造抽象类
 */
public abstract class HouseBuilder {

    abstract void addDiJi();//地基

    abstract void addGangJin();//钢筋

    abstract void addShuiNi();//水泥

    //若房子还有其他必须的可以继续添加

    abstract House getHouse();//获得最终产品-房子

}
