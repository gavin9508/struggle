package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:07
 * @Description 黑色人种
 */
public abstract class AbstractBlackHuman implements Human{
    public void getColor(){
        System.out.println("黑色人种的皮肤颜色是黑色的！");
    }
    public void talk() {
        System.out.println("黑人会说话，一般人听不懂。");
    }
}
