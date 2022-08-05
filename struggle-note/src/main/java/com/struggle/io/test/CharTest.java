package com.struggle.io.test;

/**
 * @Author gavin
 * @Date 2022/8/5 17:59
 */
public class CharTest {

    public static void main(String[] args) {

        char a = '\uffff';
        //超出 char 的承受范围的字符，无法表示。
        //char b = '\uD801\uDC37';
        System.out.println(a);
    }


}
