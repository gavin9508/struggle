package com.struggle.design.decorate;

/**
 * @Author gavin
 * @Date 2022/7/25 22:09
 */
public class TianESkin implements Skin {

    /**
     * 每个皮肤维护一个英雄
     */
    private Hero hero;

    public TianESkin(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String name() {
        return "天鹅之梦-" + hero.name();
    }

    @Override
    public int baseDamage() {
        return 10 + hero.baseDamage();
    }
}
