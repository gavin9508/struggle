package com.struggle.exception.test;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author gavin
 * @Date 2022/8/13 22:03
 */
public class ExceptionTest {

    /**
     * 内存溢出错误
     */
    @Test
    public void errorTest() {
        List<String> list = new ArrayList<String>();
        while (true) {
            list.add("内存溢出");
        }
    }

    /**
     * 不受检查异常
     */
    @Test
    public void uncheckedTest() {
        System.out.println(10 / 0);
    }

    /**
     * 受检查异常
     */
    @Test
    public void checkedTest() {
//        Scanner scanner = new Scanner(new File("src/main/java/com/struggle/exception/file/test.txt"));
//        while (scanner.hasNext()) {
//            System.out.println(scanner.nextLine());
//        }
    }

    /**
     * try-catch-finally 处理异常
     */
    @Test
    public void tryTest() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/java/com/struggle/exception/file/test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            scanner.close();
            System.out.println("关闭流");
        }
    }

    /**
     * throws 处理异常
     */
    @Test
    public void throwsTest() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/com/struggle/exception/file/test.txt"));
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    /**
     * try-with-resouces
     */
    @Test
    public void resourceTest() {
        try (Scanner scanner = new Scanner(new File("src/main/java/com/struggle/exception/file/test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    /**
     * try-with-resouces
     * 自定义资源
     */
    @Test
    public void myResourceTest() {
        try (MyInput myInput = new MyInput()) {

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
