package com.struggle.base.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1.调用Collections.sort()方法，通过定制排序比较两个Employee (先按年龄比，年龄相同按姓名比)，使用Lambda 作为参数传递
 * 2.①声明函数式接口，接口中声明抽象方法，public String getValue(String str);
 * ②声明类 TestLambda ，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值
 * ③再将一个字符串的第2个和第4个索引位置进行截取子串
 * 3.①声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
 * ②接口中声明对应抽象方法
 * ③在TestLambda类中声明方法，使用接口作为参数，计算两个long 型参数的和
 * ④再计算两个long型参数的乘积
 */
public class TestLambda3 {
    static List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9090.90),
            new Employee("王武", 35, 4567.90),
            new Employee("王二", 45, 9090.90),
            new Employee("李四", 34, 567.90),
            new Employee("小平", 18, 9090.90)
    );

    @Test
    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e1.getName());
            } else {
                return Integer.compare(e1.getAge(), e1.getAge());
            }
        });
        employees.forEach(System.out::println);
    }

    @Test
    public void test2() {
        String a = operation("adfd", (s) -> s.toUpperCase());
        System.out.println(a);
        String b = operation("sadasjdnj", (str -> str.substring(2, 5)));
        System.out.println(b);
    }

    public String operation(String str, MyString ms) {
        return ms.getValue(str);
    }

    @Test
    public void test3() {
        operation2(100L, 320L, (x, y) -> x + y);
        operation2(100L, 322L, (x, y) -> x * y);
    }

    public void operation2(Long l1, Long l2, MyLong<Long, Long> ml) {
        System.out.println(ml.getValue(l1, l2));
    }


    @Test
    public void test4() {
        List<String> pointList = Arrays.asList("232","2323","3232","wew");
        pointList.replaceAll((String p) -> {
            if(p.contains("w")){
                return p+"dada";
            }else {
                return p;
            }
        });
        pointList.forEach(point->{
            System.out.println(point);
        });
    }
}

//函数式接口
@FunctionalInterface
interface MyString {
    String getValue(String str);
}

interface MyLong<T, R> {

    Long getValue(T l1, R l2);
}
