package com.struggle.design.adapter;

/**
 * @Author sly
 * @Date 2022/7/22 23:20
 * @Description 步骤3：创建适配器类（Adapter）
 */
public class Adapter220V extends PowerPort220V implements Target {
    //期待的插头要求调用 Convert_110v()，但原有插头没有,因此适配器补充上这个方法名
    //但实际上 Convert_110v()只是调用原有插头的 Output_220v()方法的内容
    //所以适配器只是将 Output_220v()作了一层封装，封装成 Target 可以调用的Convert_110v()而已

    @Override
    public void Convert_110v() {
        System.out.println("适配器将 220V 转为 110V");
        this.Output_220v();
    }
}
