package com.struggle.design.builder.demo3;

import java.util.ArrayList;

/**
 * @Author sly
 * @Date 2022/7/29 22:16
 * @Description 奔驰组装者
 */
public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {
        return this.bmw;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}
