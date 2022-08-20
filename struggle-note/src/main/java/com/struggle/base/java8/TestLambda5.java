package com.struggle.base.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author sly
 * @Date 2022/8/5 22:46
 * @Description
 */
public class TestLambda5 {
    /**
     * 演示对象：实例方法名称1
     */
    @Test
    public void test1() {
        //未使用方法引用
        Consumer<String> con1 = (x) -> System.out.println(x);
        con1.accept("abc");
        /**
         * 分析：
         * 在未使用方法引用的时候，lambad的实现体中，要做的事情是将输入的数据打印出来；
         * 他调用的是System.out获取到的输出流中的println方法；
         * 当在lambad要实现的抽象类中的方法参数列表和返回值与已有的某个方法一致的时候，
         * 并且要做的操作也是一样的时候，那么我们就可以使用方法引用；
         * 而这里使用的是实例对象::实例方法名称的方式进行调用；
         * 所以，可以将其改造成如下:
         */
        //使用方法引用
        Consumer<String> con2 = System.out::println;
        con2.accept("abc");


    }

    /**
     * 演示对象：实例方法名称2
     */
    @Test
    public void test2() {
        Employee emp = new Employee("丑小鸭", 23, 15000.0);
        //未使用方法引用
        Supplier<String> sup1 = () -> emp.getName();
        String name = sup1.get();
        System.out.println(name);

        //使用方法引用
        Supplier<Integer> sup2 = emp::getAge;
        Integer age = sup2.get();
        System.out.println(age);
    }

    /**
     * 演示类::静态方法名称1
     */
    @Test
    public void test3() {

        //未使用方法引用
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(13, 12));
        //使用方法引用

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(13, 12));

    }

    /**
     * 演示类::实例方法名称
     */
    @Test
    public void test4() {
        //未使用方法引用
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("yb", "yb"));
        //使用方法引用
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("yb", "fly"));


    }
}
