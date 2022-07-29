package com.struggle.design.builder.demo3;

import java.util.ArrayList;

/**
 * @Author sly
 * @Date 2022/7/29 22:13
 * @Description 奔驰车组装者
 */
public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
