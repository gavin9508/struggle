package com.struggle.design.factory.simple;

/**
 * 静态工厂模式
 * 增加一个新产品，如果你不修改代码，做不到！
 * 例如：添加一个大众，需要在加一个if判断
 * 违反开闭原则（拓展开放，修改关闭）
 */
public class CarFactory {
    
    //方法一
    public static Car getCar(String type) {
        if (type.equals("五菱")) {
            return new WuLing();
        } else if (type.equals("特斯拉")) {
            return new Tesla();
        } else {
            return null;
        }
    }

    //方法二
    public static Car getWuLing() {
        return new WuLing();
    }

    public static Car getTesla() {
        return new Tesla();
    }
}
