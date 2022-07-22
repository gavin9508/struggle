package com.struggle.wkl.unlock;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁
 */
public class Person {
    private String name;
    private Integer age;
    private String address;
    private boolean man;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address='").append(address).append('\'');
        sb.append(", hashCode='").append(hashCode()).append('\'');
        sb.append(",").append(getClass().getName())
                .append("@").append(Integer.toHexString(hashCode()));
        sb.append('}');
        return sb.toString();
    }

    public static void printf(Person p) {
        // 查看对象的整体结构信息
        // JOL工具类
        System.out.println(ClassLayout.parseInstance(p).toPrintable());
    }

    /**
     * jvm使用偏向锁是有延迟的，在系统启动4s后才开启偏向锁
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
//        Thread.sleep(5000);//休眠5秒
        //创建一个实例
        Person person = new Person();
        //输出信息
        System.out.println(
                "============================before lock============================");
        Person.printf(person);
        synchronized (person) {
            System.out.println(
                    "============================locked============================");
            Person.printf(person);
        }
        //输出信息
        System.out.println(
                "============================after lock============================");
        Person.printf(person);
    }
    //输出结果before(101) locked(101) after(101)，biased_lock为1,锁标识为01，即为偏向锁
    //VALUE括号内第一组数的最后三位，倒数第三位表示是否偏向锁，后两位是锁标识位
    //具体可对照 【对象头中的markword布局】
    /**
     * OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
     *    0     4                     (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
     * OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
     *    0     4                     (object header)                           05 40 da 02 (00000101 01000000 11011010 00000010) (47857669)
     * OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
     *    0     4                     (object header)                           05 40 da 02 (00000101 01000000 11011010 00000010) (47857669)
     */
    //不休眠5秒的话 before(001) locked(000) after(001)，即无锁->轻量级锁->无锁
}


