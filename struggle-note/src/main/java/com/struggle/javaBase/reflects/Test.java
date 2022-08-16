package com.struggle.javaBase.reflects;

import com.struggle.javaBase.domain.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.struggle.javaBase.domain.User");
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------");
        User user = new User("0001", 20, "北京海淀", true);
        Class<? extends User> userClass = user.getClass();
        try {
            Field[] fields = userClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName() + ":" + field.get(user));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------");
        try {
            Class<?> aClass = Class.forName("com.struggle.javaBase.reflects.CustomerService");
            Method login = aClass.getDeclaredMethod("login", String.class, String.class);
            Object obj = aClass.newInstance();
            Object admin = login.invoke(obj, "admin", "123");
            System.out.println(admin);

            Method logout = aClass.getDeclaredMethod("logout");
            logout.invoke(obj);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
