package com.struggle.design.adapter;

/**
 * @Author sly
 * @Date 2022/7/22 23:19
 * @Description 步骤1：创建Target接口（期待得到的插头）：能输出110V
 */
public interface Target {
    //将 220V 转换输出 110V
    public void Convert_110v();
}