package com.struggle.design.strategy.strategyAndSimple;

/**
 * 策略 + 简单工厂
 */
public class CashContext {
    private CashSuper cashSuper;//声明一个CashSuper对象

    //此时不是传入具体的策略对象了，而是一个字符串，表示收费类型
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                cashSuper = new CashNomal();
                break;
            case "八折":
                cashSuper = new CashRebate(0.8);
                break;
            case "满300减100":
                cashSuper = new CashReturn(300, 100);
                break;
            default:
                cashSuper = new CashNomal();
                break;
        }
        //将实例化具体策略的过程有客户端转移到Context类中。简单工厂的应用
    }

    public double getMoney(double money) {
        return cashSuper.acceptCash(money);//根据具体的策略对象，调用其算法的方法
    }
}
