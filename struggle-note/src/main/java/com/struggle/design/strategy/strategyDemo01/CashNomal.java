package com.struggle.design.strategy.strategyDemo01;

/**
 * 正常收费子类
 * 具体策略类，封装了具体的算法或行为
 */
public class CashNomal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
