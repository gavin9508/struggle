package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:11
 * @Description
 */
public interface HumanFactory {
    //制造一个黄色人种
    public Human createYellowHuman();
    //制造一个白色人种
    public Human createWhiteHuman();
    //制造一个黑色人种
    public Human createBlackHuman();
}
