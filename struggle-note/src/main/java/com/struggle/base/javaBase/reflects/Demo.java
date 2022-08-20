package com.struggle.base.javaBase.reflects;

import com.struggle.base.javaBase.domain.User;
import org.junit.Test;

import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.struggle.base.javaBase.domain.User");
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
            Class<?> aClass = Class.forName("com.struggle.base.javaBase.reflects.CustomerService");
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

    @Test
    public void demo1() {
        try {
            Class<?> userClass = Class.forName("com.struggle.base.javaBase.domain.User");
            Object userObj = userClass.newInstance();

            //Field id = userClass.getField("id");//java.lang.NoSuchFieldException: id
            Field age = userClass.getDeclaredField("age");//public int age;
            age.set(userObj, 100);
            System.out.println(age.get(userObj));

            Field id = userClass.getDeclaredField("id");//private String id;
            /*
            java.lang.IllegalAccessException:
            Class com.struggle.javaBase.reflects.Demo can not access a member of
            class com.struggle.javaBase.domain.User with modifiers "private"
             */
            //需要打破封装
            id.setAccessible(true);
            id.set(userObj, "u-001");
            System.out.println(id.get(userObj));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo2() {
        try {
            Class<?> userClass = Class.forName("com.struggle.base.javaBase.domain.User");
            Field[] fields = userClass.getDeclaredFields();
            Constructor<?>[] constructors = userClass.getDeclaredConstructors();
            Method[] methods = userClass.getDeclaredMethods();

            StringBuilder sb = new StringBuilder();
            sb.append(Modifier.toString(userClass.getModifiers())).append(" class ").append(userClass.getSimpleName()).append("{\n");

            for (Field field : fields) {
                sb.append("\t").append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ").append(field.getName()).append(";\n");
            }
            for (Constructor con : constructors) {
                sb.append("\t").append(Modifier.toString(con.getModifiers())).append(" ")
                        .append(userClass.getSimpleName()).append("(");
                Class[] types = con.getParameterTypes();
                for (int i = 0; i < types.length; i++) {
                    if (i != types.length - 1) {
                        sb.append(types[i].getSimpleName()).append(", ");
                    } else {
                        sb.append(types[i].getSimpleName());
                    }
                }
                sb.append("){}\n");
            }

            for (Method method : methods) {
                sb.append("\t").append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("(");
                Class[] types = method.getParameterTypes();
                for (int i = 0; i < types.length; i++) {
                    if (i != types.length - 1) {
                        sb.append(types[i].getSimpleName()).append(", ");
                    } else {
                        sb.append(types[i].getSimpleName());
                    }
                }
                sb.append("){}\n");
            }
            System.out.println(sb.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo3() {
        try {
            String reference = "com.struggle.javaBase.reflects.CustomerService";
            Class<?> cusClass = Class.forName(reference);
            String methods = getMethods(reference);
            System.out.println(methods);
            Method login = cusClass.getDeclaredMethod("login", String.class, String.class);
            Object obj = cusClass.newInstance();
            boolean isLogin = (boolean) login.invoke(obj, "admin", "123");
            System.out.println(isLogin);

            Method logout = cusClass.getDeclaredMethod("logout");
            Object invoke = logout.invoke(obj);
            System.out.println(String.valueOf(invoke));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void demo4() {
        String reference = "com.struggle.javaBase.domain.User";
        String methods = getFields(reference);
        System.out.println(methods);
    }
    private String getFields(String reference) {
        StringBuilder sb = new StringBuilder();
        Class<?> userClass = null;
        try {
            userClass = Class.forName(reference);
            sb.append(Modifier.toString(userClass.getModifiers())).append(" class ").append(userClass.getSimpleName()).append("{\n");
            Field[] fields = userClass.getDeclaredFields();
            for (Field field : fields) {
                sb.append("\t").append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ").append(field.getName()).append(";\n");
            }
            sb.append("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String getMethods(String reference) {
        StringBuilder sb = new StringBuilder();
        Class<?> userClass = null;
        try {
            userClass = Class.forName(reference);
            sb.append(Modifier.toString(userClass.getModifiers())).append(" class ").append(userClass.getSimpleName()).append("{\n");
            Method[] methods = userClass.getDeclaredMethods();
            for (Method method : methods) {
                sb.append("\t").append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("(");
                Class[] types = method.getParameterTypes();
                for (int i = 0; i < types.length; i++) {
                    if (i != types.length - 1) {
                        sb.append(types[i].getSimpleName()).append(", ");
                    } else {
                        sb.append(types[i].getSimpleName());
                    }
                }
                sb.append("){}\n");
            }
            sb.append("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private String getConstructors(String reference) {
        StringBuilder sb = new StringBuilder();
        Class<?> userClass = null;
        try {
            userClass = Class.forName(reference);
            sb.append(Modifier.toString(userClass.getModifiers())).append(" class ").append(userClass.getSimpleName()).append("{\n");
            Constructor<?>[] constructors = userClass.getDeclaredConstructors();
            for (Constructor con : constructors) {
                sb.append("\t").append(Modifier.toString(con.getModifiers())).append(" ")
                        .append(userClass.getSimpleName()).append("(");
                Class[] types = con.getParameterTypes();
                for (int i = 0; i < types.length; i++) {
                    if (i != types.length - 1) {
                        sb.append(types[i].getSimpleName()).append(", ");
                    } else {
                        sb.append(types[i].getSimpleName());
                    }
                }
                sb.append("){}\n");
            }
            sb.append("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
