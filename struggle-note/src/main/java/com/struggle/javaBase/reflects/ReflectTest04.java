package com.struggle.javaBase.reflects;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * java.lang.reflect.Field; 类中的属性
 **/
public class ReflectTest04 {
    public static void main(String[] args) throws Exception {

        //获取整个类
        Class c = Class.forName("java.lang.Integer");

        Field[] fs = c.getFields();//获取所有的public修饰的属性
        System.out.println(fs.length);
        System.out.println(fs[0].getName());
        for (Field field : fs) {
            int modifiers = field.getModifiers();
            String str = Modifier.toString(modifiers);
            System.out.print(modifiers + " " + str);

            Class<?> type = field.getType();
            String simpleName = type.getSimpleName();
            String name = type.getName();
            System.out.print(" type:" + type + ", simpleName:" + simpleName + ", name:" + name);

            String fieldName = field.getName();
            System.out.println(" " + fieldName);
        }

        System.out.println("-----------------------------------------------------------------------------------");
        Field[] fields = c.getDeclaredFields();//获取所有的属性
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(c.getModifiers())).append(" class ").append(c.getSimpleName()).append("{\n");
        for (Field field : fields) {
            sb.append("\t")
                    .append(Modifier.toString(field.getModifiers())).append(" ")
                    .append(field.getType().getSimpleName()).append(" ")
                    .append(field.getName()).append(";\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }
}