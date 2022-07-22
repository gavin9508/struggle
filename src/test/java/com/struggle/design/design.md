# 1 设计模式

## 1.1 使用设计模式的目的

> 1. 提高代码的可重复利用
> 2. 提高代码的可读性
> 3. 保障代码的可靠性

## 1.2 设计模式的六大原则

> 1. 单一职责原则：类或者接口要实现职责单一
> 2. 里氏替换原则：使用子类来替换父类，做出通用的编程
> 3. 依赖倒置原则：面向接口编程
> 4. 接口隔离原则：接口的设计需要精简单一
> 5. 迪米特法则：降低依赖之间耦合
> 6. 开闭原则：对扩展开放，对修改关闭

## 1.3 单例模式---singleton

单例模式（Singleton Pattern）是 Java 中最常见的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一 种创建对象的最佳方式。

单例模式：涉及到一个单一的类，该类负责创建自己的对象，同时确保只有一个对象被创建。该类还提供一种访问他的唯一对象的方式，其他类可以直接访问该方法获取该对象实例而不需要实例化该类的对象。

单例模式的特点：
> 1. 单例类只能有一个实例。
> 2. 单例类必须自己创建自己的唯一实例。
> 3. 单例类必须给所有其他对象提供这一实例。

单例模式的优点：
> 1. 在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例。
> 2. 避免对资源的多重占用（比如写文件操作）。

单例模式的真实使用场景：
> 1. 网站的计数器
> 2. 应用程序的日志应用
> 3. 数据库连接池设计
> 4. 多线程的线程池设计

实现步骤：
> 1. 整个应用只有一个自己的实例
> 2. 只能自己创建自己
> 3. 需要提供一个方法让外界访问自己

### 1.3.1 饿汉式

> 创建一个单例对象 HungrySingleModel , HungrySingleModel 类有它的私有构造函数和本身的一个静态实例。
> HungrySingleModel 类提供了一个静态方法，供外界获取它的静态实例。 SingletonTest 我们的演示类使用 HungrySingleModel 类来获取对象。

### 1.3.2 懒汉式

> 1. 延迟加载创建，也就是用到对象的时候，才会创建
> 2. 线程安全问题需要手动处理(不添加同步方法，线程不安全，添加了同步方法，效率低)
> 3. 实现容易

### 1.3.3 双重检验锁

> 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
>
> 如果有A，B两个线程，第一次判断null,如果A和B为null,这样A和B就是并发场景。A获取锁进入下一个判断为null就会创建实例,释放锁。B获取锁进来，如果没有第二次判断为null，则B还会创建实例。

## 1.4 观测者模式---observer

定义：
> 对象之间存在一对多或者一对一依赖，当一个状态改变，依赖他的对象会收到他的消息并自动更新
>
> MQ其实就属于一种观察者模式，发布者发布信息，订阅者获取信息，订阅了就能收到信息，没订阅就收不到信息。

优点：
> 1. 观察者和被观察者是抽象耦合的
> 2. 建立一套独立的触发机制

缺点：
> 1. 如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间
> 2. 如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃

## 1.5 工厂模式---product

定义：
> 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种
> 创建对象的最佳方式。它负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的
> 产品对象

优点：
> 1. 一个调用者想创建一个对象，只要知道其名称就可以了。
> 2. 屏蔽产品的具体实现，调用者只关心产品的接口。
> 3. 降低了耦合度

说明：
> 工厂模式的思想主要为：多个类似的子类继承同一个父类，对其父类中的变量进行操作；
> 工厂类负责判断、控制哪个子类被执行，而工厂类调用子类完成后，返回的结果是该子类的父类，该父类中的变量已经被操作过了，访问该父类，得到我们想要的结果。

## 1.6 策略模式--strategy

策略模式，指的是定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化。

说明：
> 策略模式只适用管理一组同类型的算法，并且这些算法是完全互斥的情况。
> 也就是说任何时候，多个策略中只有一个可以生效的那一种。如满减中的满28减18与满58减38之间；普通会员折扣与超级会员折扣之间等。

缺点：
> 1. 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道算法或行为的情况。
> 2. 由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。

## 1.7 代理模式--proxy

定义：
> 给目标对象提供一个代理对象，并由代理对象控制对目标对象的引用；

目的：
> 1. 通过引入代理对象的方式来间接访问目标对象，防止直接访问目标对象给系统带来的不必要复杂性；
> 2. 通过代理对象对原有的业务增强；
     举例：明星 ---经纪人<-------用户

代理模式有静态代理和动态代理两种实现方式。

### 1.7.1 静态代理

这种代理方式需要代理对象和目标对象实现一样的接口。

> 优点：可以在不修改目标对象的前提下扩展目标对象的功能。
> 缺点：冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。 不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改

staticProxy/IUserDao.java

```java
package com.struggle.design.staticProxy;

public interface IUserDao {
    void save();
}
```

staticproxy/UserDao.java

```java
package com.struggle.design.staticProxy;

//目标对象
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
```

staticProxy/UserDaoProxy.java

```java
package com.struggle.design.staticProxy;

//代理对象
public class UserDaoProxy implements IUserDao {
    private IUserDao target;//null 目标对象

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
```

staticProxy/App.java

```java
package com.struggle.design.staticProxy;

public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao(); //多态目标对象
        IUserDao proxy = new UserDaoProxy(target);//代理对象
        //target.save();
        proxy.save();
    }
}
```

### 1.7.2 动态代理

动态代理利用了JDK API，动态地在内存中构建代理对象，从而实现对目标对象的代理功能。 动态代理又被称为JDK代理或接口代理。

dynamicProxy/IUserDao.java

```java
package com.open.design.dynamicProxy;

// 接口
public interface IUserDao {
    void save();
}
```

dynamicProxy/UserDao.java

```java
package com.open.design.dynamicProxy;

//目标对象
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("-----已经保存数据！！！------");
    }
}
```

dynamicProxy/ProxyFactory.java

```java
package com.open.design.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 给所有的 dao 创建代理对象【动态代理】
 * 代理对象，不需要实现接口
 *
 */
public class ProxyFactory {
    private Object target; //目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //返回一个代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                //指定当前目标对象是那个类
                target.getClass().getClassLoader(), //userDao
                //userDao 接口是那个
                target.getClass().getInterfaces(), //IUserDao
                //找目标对象中的那个方法去调用
                new InvocationHandler() {
                    //proxy 目标对象
                    //method 调用方法
                    //args 参数
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        System.out.println("开启事务");
                        Object returnValue = method.invoke(target, args);//执
                        行目标对象中的方法
                        System.out.println("提交事务");
                        return returnValue;
                    }
                });
    }
}
```

dynamicProxy/App.java

```java
package com.open.design.dynamicProxy;

public class App {
    public static void main(String[] args) {
        IUserDao target = new UserDao();//目标对象
        System.out.println(target.getClass());
        //代理对象
        IUserDao proxy = (IUserDao) new
                ProxyFactory(target).getProxyInstance();
        proxy.save();
    }
}
```

### 1.7.3 静态代理与动态代理的区别
> 1. 静态代理在编译时就已经实现，编译完成后代理类是一个实际的class 文件
> 2. 动态代理是在运行时动态生成的，即编译完成后没有实际的 class 文件，而是在运行时动态
   生成类字节码，并加载到 JVM 中 。

注意：动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
  
JDK 中生成代理对象主要涉及两个类：
> 1. 第一个类为 java.lang.reflect.Proxy，通过静态方法newProxyInstance 生成代理对象， 
> 2. 第二个为java.lang.reflect.InvocationHandler 接口，通过invoke方法对业务进行增强