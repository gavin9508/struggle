package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:05
 * @Description 白色人种
 */
public abstract class AbstractWhiteHuman implements Human{
    //白色人种的皮肤颜色是白色的
    public void getColor(){
        System.out.println("白色人种的皮肤颜色是白色的！");
    }
    //白色人种讲话
    public void talk() {
        System.out.println("白色人种会说话，一般说的都是单字节。");
    }
}
