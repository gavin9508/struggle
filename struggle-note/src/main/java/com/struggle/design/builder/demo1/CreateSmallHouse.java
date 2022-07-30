package com.struggle.design.builder.demo1;

public class CreateSmallHouse extends HouseBuilder {

    House house;

    public CreateSmallHouse() {
        this.house = new House();
    }

    @Override
    void addDiJi() {
        house.setDiJi("建小房子需要小地基");
    }

    @Override
    void addGangJin() {
        house.setGangJin("建小房子需要少钢筋");
    }

    @Override
    void addShuiNi() {
        house.setShuiNi("建小房子需要少水泥");
    }

    @Override
    House getHouse() {
        return house;
    }
}
