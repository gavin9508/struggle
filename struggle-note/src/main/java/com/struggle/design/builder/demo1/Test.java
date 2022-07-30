package com.struggle.design.builder.demo1;

public class Test {
    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector();
        House house = houseDirector.createHouse(new CreateBigHouse());
        System.out.println(house.toString());

        System.out.println("=================================================");
        house = houseDirector.createHouse(new CreateSmallHouse());
        System.out.println(house.toString());
    }
}
