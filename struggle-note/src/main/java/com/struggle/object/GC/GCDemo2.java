package com.struggle.object.GC;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试MinorGC、MajorGC、FullGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 *
 * -Xms 用于表示堆区的初始内存，等价于 -XX:InitialHeapSize
 * -Xmx 则用于表示堆区的最大内存，等价于 -XX:MaxHeapSize
 * 一旦堆区中的内存大小超过“-Xmx”所指定的最大内存时，将会抛出OutofMemoryError异常
 * 通常会将-Xms和-Xmx两个参数配置相同的值，其目的是为了能够在Java垃圾回收机制清理完堆区后不需要重新分隔计算堆区的大小，从而提高性能
 *
 * 查看设置的参数：方式一： jps   /  jstat -gc 进程id
 *                方式二：-XX:+PrintGCDetails
 */
public class GCDemo2 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }

        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }
}

