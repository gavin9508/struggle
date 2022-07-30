package com.struggle.design.prototyp.example_2;

import org.openjdk.jol.vm.VM;

/**
 * @Author sly
 * @Date 2022/7/30 22:52
 * @Description 浅拷贝测试
 */
public class Client {
    public static void main(String[] args) {
        // 获取原型管理器对象
        PrototypeManager prototypeManager = PrototypeManager.getPrototypeManager();

        RoleCopy role1, role2, role3, role4;

        role1 = (HuTao)prototypeManager.getRole("HuTao");
        role1.display();
        role2 = prototypeManager.getRole("HuTao");
        role2.display();
        System.out.println(VM.current().addressOf(role1));
        System.out.println(VM.current().addressOf(role2));
        System.out.println(VM.current().addressOf(((HuTao) role1).getSkill()));
        System.out.println(VM.current().addressOf(((HuTao) role2).getSkill()));
        System.out.println("============");
        role3 = prototypeManager.getRole("GanYu");
        role3.display();
        role4 = prototypeManager.getRole("GanYu");
        role4.display();
        System.out.println(role3 == role4);
    }
}
