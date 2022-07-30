package com.struggle.design.prototyp.example_2;

/**
 * 胡桃类
 * @Author sly
 * @Date 2022/7/30 22:50
 */
public class HuTao implements RoleCopy {

    private  Skill  skill= new Skill();

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public RoleCopy clone() {
        RoleCopy srs = null;
        try {
            srs = (RoleCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
        }
        return srs;
    }

    @Override
    public void display() {
        skill.recover();
        System.out.println("大丘丘病了，二丘丘瞧，三丘丘采药，四丘丘嗷~~~");
    }
}
