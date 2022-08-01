package com.struggle.design.responsibility.demo_1;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author sly
 * @Date 2022/8/1 23:20
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        //随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList();
        for(int i=0;i<5;i++){
            arrayList.add(new Women(rand.nextInt(4),"我要出去逛街"));
        }
        //定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        //设置请示顺序
        father.setNext(husband);
        husband.setNext(son);
        for(IWomen women:arrayList){
            father.HandleMessage(women);
        }
    }
}