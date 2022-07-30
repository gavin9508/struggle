package com.struggle.design.prototyp.example_2;

import java.util.Hashtable;
/**
 * @Author sly
 * @Date 2022/7/30 22:49
 * @Description 原型管理器（使用饿汉式单例实现）
 */

public class PrototypeManager {
    /**
     * 定义一个Hashtable，用于存储原型对象
     */
    private Hashtable hashtable = new Hashtable();
    /**
     * 定义一个原型管理器实例，设置为静态变量
     */
    private static PrototypeManager prototypeManager = new PrototypeManager();

    /**
     * 构造方法，为hashtable添加角色。
     * 注意这里的构造方法是私有的
     */
    private PrototypeManager() {
        hashtable.put("GanYu", new GanYu());
        hashtable.put("HuTao", new HuTao());
    }

    /**
     * 增加新的角色
     * @param key
     * @param roleCopy
     */
    public void addRole(String key, RoleCopy roleCopy) {
        hashtable.put(key, roleCopy);
    }

    /**
     * 通过浅克隆获取新的角色对象
     * @param key
     * @return 克隆的角色对象
     */
    public RoleCopy getRole(String key) {
        return ((RoleCopy) hashtable.get(key)).clone();
    }

    /**
     * 静态方法，返回原型管理器
     * @return 原型管理器
     */
    public static PrototypeManager getPrototypeManager() {
        return prototypeManager;
    }
}