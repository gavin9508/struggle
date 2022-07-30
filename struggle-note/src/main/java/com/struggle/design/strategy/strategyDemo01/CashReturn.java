package com.struggle.design.strategy.strategyDemo01;

/**
 * 返利收费子类
 * 具体策略类，封装了具体的算法或行为
 */
public class CashReturn extends CashSuper {
    private double moneyCondition;//货币状况，返利基数
    private double moneyReturn;//返利

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        if (money > moneyCondition) {
            return money - (int)(money / moneyCondition) * moneyReturn;
        }
        return money;
    }

}
