package com.struggle.design.builder.demo1;

/**
 * 指挥
 */
public class HouseDirector {
    public House createHouse(HouseBuilder houseBuilder) {

        houseBuilder.addDiJi();
        houseBuilder.addGangJin();
        houseBuilder.addShuiNi();

        return houseBuilder.getHouse();
    }
}
