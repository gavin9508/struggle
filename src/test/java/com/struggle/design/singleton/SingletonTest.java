package com.struggle.design.singleton;
import com.carrotsearch.sizeof.RamUsageEstimator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 单例测试类
 */
public class SingletonTest {
    //测试单例
    public static void main(String[] args) {
        System.out.println("===========测试单例=============");
        HungrySingleModel instance1 = HungrySingleModel.getInstance();
        HungrySingleModel instance2 = HungrySingleModel.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);

        System.out.println("==========单例对象的内存消耗=============");
        //存储创建的新实例对象
        List<HungrySingleModel> array = new ArrayList<>();
        //获取实例
        HungrySingleModel singleModel1 = HungrySingleModel.getInstance();
        array.add(singleModel1);
        for (int i = 0; i < 100000; i++) {
            HungrySingleModel singleModel2 = HungrySingleModel.getInstance();
            if (singleModel1 != singleModel2) {
                array.add(singleModel2);
            }
        }
        System.out.println(RamUsageEstimator.sizeOf(array));

        System.out.println("=============非单例对象的内存消耗==============");
        ArrayList<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal();
        animals.add(animal1);
        for (int i = 0; i < 100000; i++) {
            Animal animal2 = new Animal();
            if (animal1 != animal2) {
                animals.add(animal2);
            }
        }
        System.out.println(RamUsageEstimator.sizeOf(animals));
    }
}

/**
 * @author sly
 * @version 1.0
 * @Date 2022/7/21 23:03
 * @Description 非单例对象
 */
class Animal{
    private String name;

    private String age;

    private String type;

    public Animal() {
    }

    public Animal(String name, String age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}