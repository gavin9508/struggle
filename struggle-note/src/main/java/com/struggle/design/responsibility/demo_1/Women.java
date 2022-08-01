package com.struggle.design.responsibility.demo_1;

/**
 * @Author sly
 * @Date 2022/8/1 23:19
 * @Description
 */
public class Women implements IWomen{
    /*
     * 通过一个int类型的参数来描述妇女的个人状况
     * 1--未出嫁
     * 2--出嫁
     * 3--夫死
     */
    private int type=0;
    //妇女的请示
    private String request = "";
    //构造函数传递过来请求
    public Women(int _type,String _request){
        this.type = _type;
//为了便于显示，在这里做了点处理
        switch(this.type){
            case 1:
                this.request = "女儿的请求是：" + _request;
                break;
            case 2:
                this.request = "妻子的请求是：" + _request;
                break;
            case 3:
                this.request = "母亲的请求是：" + _request;
        }
    }
    //获得自己的状况
    public int getType(){
        return this.type;
    }
    //获得妇女的请求
    public String getRequest(){
        return this.request;
    }
}

