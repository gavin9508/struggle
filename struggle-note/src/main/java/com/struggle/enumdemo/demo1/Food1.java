package com.struggle.enumdemo.demo1;

public interface Food1 {
    enum Appetizer implements Food1 {
        SALAD, SOUP, SPRING_ROLLS;
    }

    enum MainCourse implements Food1 {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO;
    }

    enum Dessert implements Food1 {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }

    enum Coffee implements Food1 {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
