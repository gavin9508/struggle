package com.struggle.design.builder.demo2;

/**
 * 建造抽象类
 */
public abstract class HouseBuilder {

    abstract HouseBuilder diJi(String part);//地基

    abstract HouseBuilder gangJin(String part);//钢筋

    abstract HouseBuilder shuiNi(String part);//水泥

    //若房子还有其他必须的可以继续添加

    abstract House getHouse();//获得最终产品-房子

}
