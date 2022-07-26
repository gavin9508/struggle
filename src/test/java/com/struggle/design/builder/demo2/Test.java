package com.struggle.design.builder.demo2;

public class Test {
    public static void main(String[] args) {
        HouseBuilder house = new CreateBigHouse();
        house.diJi("建大房子需要大地基").shuiNi("建大房子需要多水泥");
        System.out.println(house.getHouse().toString());

        house = new CreateSmallHouse();
        house.shuiNi("建造小房子需要少一些水泥");
        System.out.println(house.getHouse().toString());
    }
}
