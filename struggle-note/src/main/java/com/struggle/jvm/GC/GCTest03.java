package com.struggle.jvm.GC;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 * 测试：大对象直接进入老年代
 */
public class GCTest03 {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20]; //20m
    }
}
