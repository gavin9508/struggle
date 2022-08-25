package com.struggle.base.list.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author gavin
 * @Date 2022/8/25 22:51
 */
public class ListTest {
    Map<Integer, String> map = new HashMap();

    {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
    }

    @Test
    public void iteratorTest() {
        System.out.println(" ===Iterator迭代器遍历=== ");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print("key:" + entry.getKey());
            System.out.println(" val:" + entry.getValue());
        }
    }

    @Test
    public void foreachTest() {
        System.out.println(" ===foreach表达式遍历=== ");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print("key:" + entry.getKey());
            System.out.println(" val:" + entry.getValue());
        }
    }

    @Test
    public void LambdaTest() {
        System.out.println(" ===Lambda表达式遍历=== ");
        map.forEach((key, value) -> {
            System.out.print("key:" + key);
            System.out.println(" val:" + value);
        });
    }

    @Test
    public void streamTest() {
        System.out.println(" ===Streams遍历=== ");
        map.entrySet().stream().forEach((entry) -> {
            System.out.print("key:" + entry.getKey());
            System.out.println(" val:" + entry.getValue());
        });
    }
}
