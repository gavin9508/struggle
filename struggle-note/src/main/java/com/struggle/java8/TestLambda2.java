package com.struggle.java8;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda2 {
    public static void main(String[] args) {
        System.out.println("==============无参数，无返回值=============");
        test1();
        System.out.println("==========lambda体中只有一条语句=============");
        test2();
        System.out.println("===========有两个以上的参数，有返回值==========");
        test3();
        System.out.println("===========");
        test4();
    }

    public static void test1() {
        // 注意事项： 在局部内部类中应用同级别的局部变量时，该变量定义为final
        // 1.8之前需要自己手动写final，1.8之后默认
        final int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, lambda" + num);
            }
        };
        r.run();
        System.out.println("------------");
        Runnable r1 = () -> System.out.println("Hello, lambda");
        r1.run();
    }

    public static void test2() {
        Consumer<String> con = (c) -> System.out.println(c + "mii");
        con.accept("你好");
    }

    public static void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口" + x + y);
//            return x > y ? x : y;
            return Integer.compare(x, y);
        };

        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(1, 0));

    }

    // 需求：对一个数进行计算
    public static void test4() {
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);

    }

//    @FunctionalInterface
    public static Integer operation(Integer num, Myfun mf) {
        return mf.getValue(num);
    }
}

interface Myfun {

    Integer getValue(int i);
}

