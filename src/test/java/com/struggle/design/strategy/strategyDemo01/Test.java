package com.struggle.design.strategy.strategyDemo01;

public class Test {
    public static void main(String[] args) {
        CashContext cashContext = new CashContext(new CashNomal());
        double money = cashContext.getMoney(700.0);
        System.out.println(money);

        cashContext = new CashContext(new CashRebate(0.7));
        money = cashContext.getMoney(700.0);
        System.out.println(money);

        cashContext = new CashContext(new CashReturn(300, 100));
        money = cashContext.getMoney(700.0);
        System.out.println(money);
    }
}
