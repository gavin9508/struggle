package com.struggle.design.strategy.strategyAndSimple;

import java.math.BigDecimal;

/**
 * 打折收费子类
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1.0;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        BigDecimal bd1 = BigDecimal.valueOf(money);
        BigDecimal bd2 = BigDecimal.valueOf(moneyRebate);
        return Double.parseDouble(bd1.multiply(bd2).toString());
    }
}
