package com.struggle.base.enumdemo.demo1;

/**
 * @Author sly
 * @Date 2022/8/14 21:55
 * @Description 菜单类
 */
public enum Meal {
    APPETIZER(Food1.Appetizer.class),
    MAINCOURSE(Food1.MainCourse.class),
    DESSERT(Food1.Dessert.class),
    COFFEE(Food1.Coffee.class);
    private Food1[] values;
    private Meal(Class<? extends Food1> kind) {
        //通过class对象获取枚举实例
        values = kind.getEnumConstants();
    }
}
