package com.struggle.javaBase.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wkl
 * @create: 2022-08-13 21:10
 **/

public class GenericsTest {
    public static void main(String[] args) {
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if (classStringArrayList.equals(classIntegerArrayList)) {
            System.out.println("泛型测试,类型相同");
        }
    }
}
