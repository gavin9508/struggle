package com.struggle.design.factory.yuanshen;

/**
 * @Author sly
 * @Date 2022/7/27 10:36
 * @Description
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Ice ice = new WangXiaoMei();
        executeMethod(ice);
        System.out.println("===============");
        ice = new ChongYun();
        executeMethod(ice);
        System.out.println("========利用反射--类名全路径=======");
        IceFactory factory = new IceFactory();
        Ice diaona = factory.getIceByClassKey("com.struggle.design.factory.yuanshen.DiAoNa");
        executeMethod(diaona);
        System.out.println("=========反射2=========");
        ShenLiLingHua shenLiLingHua = factory.getInstance("com.struggle.design.factory.yuanshen.ShenLiLingHua", ShenLiLingHua.class);
        executeMethod(shenLiLingHua);
    }

    public static void executeMethod(Ice ice){
        ice.sex();
        ice.name();
        ice.grade();
    }
}
