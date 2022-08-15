package com.struggle.javaBase.reflects;

import com.struggle.javaBase.domain.User;

import java.lang.reflect.Field;

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

    }
}
