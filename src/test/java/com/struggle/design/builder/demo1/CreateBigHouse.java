package com.struggle.design.builder.demo1;

/**
 * 房子建造的实现类
 */
public class CreateBigHouse extends HouseBuilder {
    House house;

    public CreateBigHouse() {
        this.house = new House();
    }

    @Override
    void addDiJi() {
        house.setDiJi("建大房子需要大地基");
    }

    @Override
    void addGangJin() {
        house.setGangJin("建大房子需要多钢筋");
    }

    @Override
    void addShuiNi() {
        house.setShuiNi("建大房子需要多水泥");
    }

    @Override
    House getHouse() {
        return house;
    }
}
