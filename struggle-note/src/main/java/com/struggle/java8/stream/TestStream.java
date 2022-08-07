package com.struggle.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author sly
 * @Date 2022/8/7 22:11
 * @Description
 */
public class TestStream {
    @Test
    public void interOperation() {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        //filter筛选大于3的数
        Stream<Integer> stream = integerList.stream().filter(i -> i > 3);
        stream.forEach(s -> System.out.print(s+" "));
        System.out.println();
        //去重
        Stream<Integer> stream1 = integerList.stream().distinct();
        stream1.forEach(s -> System.out.print(s+" "));
        System.out.println();
        //返回指定个数
        Stream<Integer> stream2 = integerList.stream().limit(3);
        stream2.forEach(s -> System.out.print(s+" "));
        System.out.println();
        //跳过流中的元素
        Stream<Integer> stream3 = integerList.stream().skip(2);
        stream3.forEach(s -> System.out.print(s+" "));
        System.out.println();
        //流映射转换
        List<String> stringList = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        Stream<Integer> stream4 = stringList.stream().map(String::length);
        stream4.forEach(s -> System.out.print(s+" "));
        System.out.println();
        //流转换
        List<String> wordList = Arrays.asList("Hello", "World", "Java 8 lambdas in action");
        List<String> strList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        strList.forEach(s -> System.out.print(s+","));
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
}
