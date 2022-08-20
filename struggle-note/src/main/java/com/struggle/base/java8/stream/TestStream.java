package com.struggle.base.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @Author sly
 * @Date 2022/8/7 22:11
 * @Description
 */
public class TestStream {
    static List<Dish> dishes = Arrays.asList(
            new Dish("糖醋里脊", false, 9090, new Type("川菜")),
            new Dish("麻婆豆腐", true, 380, new Type("川菜")),
            new Dish("辣子鸡", false, 5700, new Type("川菜")),
            new Dish("剁椒鱼", false, 567, new Type("湘菜")),
            new Dish("糖油粑粑", false, 245, new Type("湘菜"))
    );

    @Test
    public void interOperation() {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        //filter筛选大于3的数
        Stream<Integer> stream = integerList.stream().filter(i -> i > 3);
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println();
        //去重
        Stream<Integer> stream1 = integerList.stream().distinct();
        stream1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        //返回指定个数
        Stream<Integer> stream2 = integerList.stream().limit(3);
        stream2.forEach(s -> System.out.print(s + " "));
        System.out.println();
        //跳过流中的元素
        Stream<Integer> stream3 = integerList.stream().skip(2);
        stream3.forEach(s -> System.out.print(s + " "));
        System.out.println();
        //流映射转换
        List<String> stringList = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        Stream<Integer> stream4 = stringList.stream().map(String::length);
        stream4.forEach(s -> System.out.print(s + " "));
        System.out.println();
        //流转换
        List<String> wordList = Arrays.asList("Hello", "World", "Java 8 lambdas in action");
        List<String> strList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        strList.forEach(s -> System.out.print(s + ","));
        System.out.println();
        //元素匹配（all）
        if (integerList.stream().allMatch(i -> i > 3)) {
            System.out.println("值都大于3");
        }
        //元素匹配any
        if (integerList.stream().anyMatch(i -> i > 3)) {
            System.out.println("存在大于3的值");
        }
        //不采用流的方式
        for (Integer i : integerList) {
            if (i > 3) {
                System.out.println("存在大于3的值");
                break;
            }
        }
        //全部都不匹配
        if (integerList.stream().noneMatch(i -> i > 3)) {
            System.out.println("值都小于3");
        }
    }

    @Test
    public void terminalOperation() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Long result = integerList.stream().count();
        System.out.println(result);
        System.out.println("=========");
        Long result1 = integerList.stream().collect(counting());
        System.out.println(result1);
        System.out.println("=========");
        Optional<Integer> result2 = integerList.stream().filter(i -> i > 3).findFirst();
        result2.ifPresent(System.out::println);
        System.out.println("=========");
        Optional<Integer> result3 = integerList.stream().filter(i -> i > 3).findAny();
        result3.ifPresent(System.out::println);
        int sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println("=========");
        sum = integerList.stream().reduce(0, (a, b) -> (a + b));
        System.out.println(sum);
        System.out.println("=========");
        sum = integerList.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("=========");
        Optional<Integer> min = dishes.stream().map(Dish::getCalories).min(Integer::compareTo);
        System.out.println("min:" + min);
        Optional<Integer> max = dishes.stream().map(Dish::getCalories).max(Integer::compareTo);
        System.out.println("max:" + max);
        OptionalInt min1 = dishes.stream().mapToInt(Dish::getCalories).min();
        System.out.println("min():" + min1);
        OptionalInt max1 = dishes.stream().mapToInt(Dish::getCalories).max();
        System.out.println("max():" + max1);
        Optional<Integer> min2 = dishes.stream().map(Dish::getCalories).collect(minBy(Integer::compareTo));
        System.out.println("minBy:" + min2);
        Optional<Integer> max2 = dishes.stream().map(Dish::getCalories).collect(maxBy(Integer::compareTo));
        System.out.println("maxBy:" + max2);
        Optional<Integer> min3 = dishes.stream().map(Dish::getCalories).reduce(Integer::min);
        System.out.println("reduce：" + min3);
        Optional<Integer> max3 = dishes.stream().map(Dish::getCalories).reduce(Integer::max);
        System.out.println("reduce:" + max3);
        sum = dishes.stream().collect(summingInt(Dish::getCalories));
        System.out.println("summingInt:" + sum);
        sum = dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("reduce:" + sum);
        sum = dishes.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("sum():" + sum);
        double average = dishes.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("averagingInt:" + average);
        IntSummaryStatistics intSummaryStatistics = dishes.stream().collect(summarizingInt(Dish::getCalories));
        average = intSummaryStatistics.getAverage();
        System.out.println("getAverage:"+average);
        //获取最小值
        int min4 = intSummaryStatistics.getMin();
        System.out.println("getMin:"+min4);
        //获取最大值
        int max4 = intSummaryStatistics.getMax();
        System.out.println("getMax:"+max4);
        //获取总和
        long sum4 = intSummaryStatistics.getSum();
        System.out.println("getSum:"+sum4);
        System.out.println("============");
        integerList.stream().forEach(System.out::println);
        System.out.println("============");
        //而在jdk8之前实现遍历：
        for (int i : integerList) {
            System.out.print(i+" ");
        }
        System.out.println("===========");
        List<String> strings = dishes.stream().map(Dish::getName).collect(toList());
        strings.forEach(s -> System.out.print(s+" "));
        Set<String> sets = dishes.stream().map(Dish::getName).collect(toSet());
        strings.forEach(s -> System.out.print(s+" "));
        List<String> stringList = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        for (Dish dish : dishes) {
            stringList.add(dish.getName());
            stringSet.add(dish.getName());
        }
        Map<Type, List<Dish>> result4 = dishes.stream().collect(groupingBy(Dish::getType));
        Optional.ofNullable(result4).ifPresent(System.out::println);
        Map<Type, Map<Object, List<Dish>>> result5 = dishes.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return "DIET";
                    else if (dish.getCalories() <= 700)
                        return "NORMAL";
                    else
                        return "FAT";
                })));
        Optional.ofNullable(result5).ifPresent(System.out::println);
        Map<Boolean, List<Dish>> result6 = dishes.stream().collect(partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(result6).ifPresent(System.out::println);
        Map<Boolean, List<Dish>> result7 = dishes.stream().collect(groupingBy(Dish::isVegetarian));
        Optional.ofNullable(result7).ifPresent(System.out::println);
        Map<Boolean, List<Integer>> result8 = integerList.stream().collect(partitioningBy(i -> i < 3));
        Optional.ofNullable(result8).ifPresent(System.out::println);
    }
}
