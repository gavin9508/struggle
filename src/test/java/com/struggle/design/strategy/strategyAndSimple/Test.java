package com.struggle.design.strategy.strategyAndSimple;

public class Test {
    public static void main(String[] args) {
        CashContext cashContext = new CashContext("正常收费");
        double money = cashContext.getMoney(700);
        System.out.println(money);

        cashContext = new CashContext("八折");
        money = cashContext.getMoney(700);
        System.out.println(money);

        cashContext = new CashContext("满300减100");
        money = cashContext.getMoney(700);
        System.out.println(money);
    }
}
