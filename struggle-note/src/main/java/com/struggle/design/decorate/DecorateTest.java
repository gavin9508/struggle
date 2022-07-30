package com.struggle.design.decorate;

import java.io.*;

/**
 * @Author gavin
 * @Date 2022/7/25 22:18
 */
public class DecorateTest {
    public static void main(String[] args) {
        Hero hero = new XiaoQiao();
        System.out.println(hero.name()+"的初始攻击力为："+hero.baseDamage());
        Hero tianE = new TianESkin(hero);
        System.out.println(tianE.name()+"的初始攻击力为："+tianE.baseDamage());
        System.out.println("===============================================");


        System.out.println("案例：JDK中InputStream家族就使用了经典的装饰者模式");
        try {
            InputStream inputStream  = new FileInputStream("src/test/java/com/struggle/design/decorate/test.txt");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
