package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:13
 * @Description
 */
public class MaleFactory implements HumanFactory{
    //生产出黑人男性
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
    //生产出白人男性
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }
    //生产出黄人男性
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }
}
