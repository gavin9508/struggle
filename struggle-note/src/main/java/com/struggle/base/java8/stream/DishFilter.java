package com.struggle.base.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author sly
 * @Date 2022/8/7 0:26
 * @Description
 */
public class DishFilter {
    static List<Dish> dishes = Arrays.asList(
            new Dish("糖醋里脊", false, 9090, new Type("川菜")),
            new Dish("麻婆豆腐", true, 380, new Type("川菜")),
            new Dish("辣子鸡", false, 5700, new Type("川菜")),
            new Dish("剁椒鱼", false, 567, new Type("湘菜")),
            new Dish("糖油粑粑", false, 245, new Type("湘菜"))
    );

    public static void main(String[] args) {
        List<String> dishFilers = beforeJava7(dishes);
        dishFilers.forEach(System.out::println);
        System.out.println("=========");
        dishFilers = afterJava8(dishes);
        dishFilers.forEach(System.out::println);
    }

    private static List<String> afterJava8(List<Dish> dishList) {
        return dishList.stream()
                .filter(dish -> dish.getCalories() < 1000)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    private static List<String> beforeJava7(List<Dish> dishList) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //1.筛选出卡路里小于400的菜肴
        for (Dish dish : dishList) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        //2.对筛选出的菜肴进行排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        //3.获取排序后菜肴的名字
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
}
