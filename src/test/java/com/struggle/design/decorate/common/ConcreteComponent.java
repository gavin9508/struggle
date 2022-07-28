package com.struggle.design.decorate.common;

/**
 * @Author sly
 * @Date 2022/7/28 16:08
 * @Description 具体构件
 */
public class ConcreteComponent extends Component {
    //具体实现
    @Override
    public void operate() {
        System.out.println("do Something");
    }
}

