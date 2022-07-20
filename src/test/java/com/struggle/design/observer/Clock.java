package com.struggle.design.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 被监听的对象
 */
public class Clock {
    private final List<AbstractInfo> infos = new ArrayList<>();

    public void say() {
        System.out.println("大家一起卷");
        //通知
        update();
    }

    //添加要得到的通知
    public void addInfo(AbstractInfo info) {
        infos.add(info);
    }

    //通知
    public void update() {
        for (AbstractInfo info : infos) {
            info.message();
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        StudyInfo studyInfo = new StudyInfo();
        SleepInfo sleepInfo = new SleepInfo();
        clock.addInfo(sleepInfo);
        clock.addInfo(studyInfo);
        clock.say();
    }
}
