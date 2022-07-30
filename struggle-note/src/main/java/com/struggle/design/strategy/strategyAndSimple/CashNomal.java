package com.struggle.design.strategy.strategyAndSimple;

/**
 * 正常收费子类
 */
public class CashNomal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
