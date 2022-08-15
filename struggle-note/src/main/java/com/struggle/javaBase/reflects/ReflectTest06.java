package com.struggle.javaBase.reflects;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
	java.lang.reflect.Method;
*/
public class ReflectTest06 {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("java.lang.String");//获取类

        Method[] ms = c.getDeclaredMethods();//获取所有的方法
        Modifier.toString(ms[0].getModifiers());//获取修饰符
        Class<?> returnType = ms[0].getReturnType();//获取方法的返回值类型
        returnType.getSimpleName();
        ms[0].getName();//获取方法名
        Class<?>[] paramTypes = ms[0].getParameterTypes();//获取方法的形式参数列表
        paramTypes[0].getSimpleName();

        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(c.getModifiers())).append(" class ").append(c.getName()).append("{\n");
        for (Method method : ms) {
            sb.append("\t").append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType().getSimpleName()).append(" ");
            sb.append(method.getName()).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i != parameterTypes.length - 1) {
                    sb.append(parameterTypes[i].getSimpleName()).append(", ");
                } else {
                    sb.append(parameterTypes[i].getSimpleName());
                }
            }
            sb.append("){}\n");
        }
        sb.append("}");
        System.out.println(sb);
    }
}