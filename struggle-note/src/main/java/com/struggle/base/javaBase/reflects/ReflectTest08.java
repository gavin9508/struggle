package com.struggle.base.javaBase.reflects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
	获取构造方法
*/
public class ReflectTest08 {
    public static void main(String[] args) throws Exception {

        //1.获取类
        Class c = Class.forName("java.lang.String");

        //2.获取所有的构造
        Constructor[] cs = c.getDeclaredConstructors();

		/*
		for(Constructor con:cs){

			//获取修饰符
			System.out.println(Modifier.toString(con.getModifiers()));

			//获取构造方法名
			System.out.println(c.getName());

			//构造方法的形式参数列表
			Class[] parameterTypes = con.getParameterTypes();
			for(Class parameterType:parameterTypes){
				System.out.println(parameterType.getSimpleName());
			}


		}
		*/

        //反编译
        StringBuffer sb = new StringBuffer();

        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + "{\n");

        //构造方法
        for (Constructor con : cs) {
            sb.append("\t");
            sb.append(Modifier.toString(con.getModifiers()) + " ");
            sb.append(c.getSimpleName() + "(");
            //形参
            Class[] parameterTypes = con.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class parameterType = parameterTypes[i];
                if (i == parameterTypes.length - 1) {
                    sb.append(parameterType.getSimpleName());
                } else {
                    sb.append(parameterType.getSimpleName() + ",");
                }

            }
            sb.append("){}\n");
        }

        sb.append("}");

        System.out.println(sb);
    }
}