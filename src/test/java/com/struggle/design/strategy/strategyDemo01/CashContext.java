package com.struggle.design.strategy.strategyDemo01;

/**
 * 上下文策略
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper) {//初始时传入具体的策略对象
        this.cashSuper = cashSuper;
    }

    public double getMoney(double money) {
        return cashSuper.acceptCash(money);//根据具体的策略对象，调用其算法的方法
    }
}
