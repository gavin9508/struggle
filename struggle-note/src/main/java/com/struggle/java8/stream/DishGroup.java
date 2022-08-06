package com.struggle.java8.stream;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author sly
 * @Date 2022/8/7 0:45
 * @Description
 */
public class DishGroup {
    static List<Dish> dishes = Arrays.asList(
            new Dish("糖醋里脊", false, 9090, new Type("川菜")),
            new Dish("麻婆豆腐", true, 380, new Type("川菜")),
            new Dish("辣子鸡", false, 5700, new Type("川菜")),
            new Dish("剁椒鱼", false, 567, new Type("湘菜")),
            new Dish("糖油粑粑", false, 245, new Type("湘菜"))
    );

    public static void main(String[] args) {
        Map<Type, List<Dish>> typeListMap = beforeJdk8(dishes);
        Optional.of(typeListMap).ifPresent(System.out::println);
        afterJdk8(dishes);
        Optional.of(typeListMap).ifPresent(System.out::println);
    }
    private static Map<Type, List<Dish>> beforeJdk8(List<Dish> dishList) {
        Map<Type, List<Dish>> result = new HashMap<>();
        for (Dish dish : dishList) {
            //不存在则初始化
            if (result.get(dish.getType())==null) {
                List<Dish> dishes = new ArrayList<>();
                dishes.add(dish);
                result.put(dish.getType(), dishes);
            } else {
                //存在则追加
                result.get(dish.getType()).add(dish);
            }
        }
        return result;
    }

    private static Map<Type, List<Dish>> afterJdk8(List<Dish> dishList) {
        return dishList.stream().collect(groupingBy(Dish::getType));
    }
}
