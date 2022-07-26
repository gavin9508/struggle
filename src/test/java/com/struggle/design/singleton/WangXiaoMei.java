package com.struggle.design.singleton;

/**
 * @Author sly
 * @Date 2022/7/26 17:28
 * @Description 唯一一只王小美
 */
public class WangXiaoMei {
    //单例类只能有一个实例。
    private volatile static WangXiaoMei wangXiaoMei;
    //单例类必须自己创建自己的唯一实例。
    String birthday;
    String shenZhiYan;
    String mingZhiZuo;

    private WangXiaoMei(String birthday,String shenZhiYan,String mingZhiZuo) {
        this.birthday = birthday;
        this.mingZhiZuo = mingZhiZuo;
        this.shenZhiYan = shenZhiYan;
        System.out.println("月海亭的秘书，体内流淌着仙兽[麒麟]的血脉。");
    }

    @Override
    public String toString() {
        return "王小美属性：{" +
                "birthday='" + birthday + '\'' +
                ", shenZhiYan='" + shenZhiYan + '\'' +
                ", mingZhiZuo='" + mingZhiZuo + '\'' +
                '}';
    }

    //单例类必须给所有其他对象提供这一实例。
    public static WangXiaoMei getInstance() {
        if (wangXiaoMei == null) {
            synchronized (WangXiaoMei.class) {
                if (wangXiaoMei == null) {
                    String birthday = "12月3日";
                    String shenZhiYan = "冰";
                    String MingZhiZuo = "仙麟座";
                    wangXiaoMei = new WangXiaoMei(birthday,shenZhiYan,MingZhiZuo);
                }
            }
        }
        return wangXiaoMei;
    }
}
class WxmTest{
    public static void main(String[] args) {
        WangXiaoMei instance = WangXiaoMei.getInstance();
        System.out.println(instance);
    }
}

