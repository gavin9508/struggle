package com.struggle.design.adapter;

/**
 * @Author sly
 * @Date 2022/7/22 23:21
 * @Description 步骤4：测试
 */

//通过 Adapter 类从而调用所需要的方法
public class ImportedTV {
    public static void main(String[] args) {
        Target mAdapter220V = new Adapter220V();
        ImportedTV mImportedMachine = new ImportedTV();
        //用户拿着进口机器插上适配器（调用 Convert_110v()方法）
        //再将适配器插上原有插头（Convert_110v()方法内部调用 Output_220v()方法输出 220 V）
        //适配器只是个外壳，对外提供 110V，但本质还是 220V 进行供电
        mAdapter220V.Convert_110v();
        mImportedMachine.Work();
    }

    public void Work() {
        System.out.println("TV 正常运行");
    }
}