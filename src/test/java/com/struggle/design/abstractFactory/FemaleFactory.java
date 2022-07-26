package com.struggle.design.abstractFactory;

/**
 * @Author sly
 * @Date 2022/7/25 22:11
 * @Description 女性工厂生产流水线
 */
public class FemaleFactory implements HumanFactory{
    //生产出黑人女性
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
    //生产出白人女性
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }
    //生产出黄人女性
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }
}
