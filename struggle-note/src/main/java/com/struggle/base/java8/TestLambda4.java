package com.struggle.base.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大核心函数式接口
 */
public class TestLambda4 {

    // Predicate<T>：断言型接口
    // 将满足条件的字符串放入集合中去
    @Test
    public void test4(){
        List<String> list = Arrays.asList("huhu","lplp","lplko","kokookok","kokokoll");
        List<String> strings = filterStr(list, (str) -> str.length() > 4);
        for (String string : strings) {
            System.out.println(string);
        }
    }
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }

    // Function<T,R>：函数型接口
    // 需求：用于处理字符串
    @Test
    public void test3(){
        String newStr = strHandler("strdcsnvns  j", (str) -> str.replace(" ",""));
        System.out.println(newStr);
    }
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    // Supplier<T>:  供给型接口
    // 需求：产生指定个数的整数，并放到集合当中去
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 10));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            list.add(sup.get());
        }
        return list;

    }
    // Consumer<T>：消费性接口
    @Test
    public void test1(){
        happy(100d,(x) -> System.out.println(x));
    }
    public void happy(Double d, Consumer<Double> con){
        con.accept(d);
    }
}

