package com.struggle.design.builder.demo2;

/**
 * 房子建造的实现类
 */
public class CreateBigHouse extends HouseBuilder {
    House house;

    public CreateBigHouse() {
        this.house = new House();
    }

    @Override
    HouseBuilder diJi(String part) {
        house.setDiJi(part);
        return this;
    }

    @Override
    HouseBuilder gangJin(String part) {
        house.setGangJin(part);
        return this;
    }

    @Override
    HouseBuilder shuiNi(String part) {
        house.setShuiNi(part);
        return this;
    }

    @Override
    House getHouse() {
        return house;
    }
}
