package com.struggle.object.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author gavin
 * @version 1.0
 * @date 2022/7/20 下午2:22
 * @Description 对象布局
 */
public class JolTest {
    public static class Object {
        int i;
        long l;
    }

    public static void main(String[] args) {
        Object instance = new Object();
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
        System.out.println("=================================================================================================================");
        System.out.println("前俩行为Mark Word  用于存储对象自身的运行时数据，如哈希码（HashCode）、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等");
        System.out.println("第三行为Klass Pointer 即类型指针，是对象指向它的类元数据的指针");
        System.out.println("第四行为int 占四个字节");
        System.out.println("第五行为long 占八个字节");
        System.out.println("第六行为Padding 如果上面的数据所占用的空间不能被8整除，padding则占用空间凑齐使之能被8整除");
    }

}
