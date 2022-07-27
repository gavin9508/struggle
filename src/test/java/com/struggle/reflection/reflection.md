# 1.反射

## 1.1 反射的定义
> JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
对于任意一个对象，都能够调用它的任意方法和属性；
这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。

## 1.2 反射的常用场景
> 第三方应用开发过程中，会需要某个类的某个成员变量、方法或是属性是私有的或者只对系统应用开放，就可以通过Java的反射机制来获取所需的私有成员或者方法

## 1.3 反射相关的类

| 类名           | 用途                          |
|--------------|:----------------------------|
| class类       | 代表类的实体，在运行时的Java应用程序中表示类和接口 |
| Field类       | 代表类的成员变量（也称类的属性）            |
| Method类      | 代表类的方法                      |
| constructor类 | 代表类的构造方法                    |

### 1.3.1 class类
> 代表类的实体，在运行的Java应用程序中表示类和接口

#### 1.3.1.1 获取类的方法
| 方法                         | 用途                          |
|----------------------------|:----------------------------|
| asSubclass(Class<U> clazz) | 把传递的类对象转换为代表其子类的对象          |
| Cast                       | 把对象转换成代表类或是接口的对象            |
| getClassLoader()           | 获取类加载器                      |
| getClasses()               | 返回一个数组，数组中包含该类中所有公共类和接口类的对象 |
| getDeclaredClasses()       | 返回一个数组，数组中包含该类中所有类和接口的对象    |
| forName(String className)  | 根据类名返回类的对象                  |
| getName()                  | 获取类的完整路径名字                  |
| newInstance()              | 创建类的实例                      |
| getPackage()               | 获取类的包                       |
| getSimpleName()            | 获取类的名字                      |
| getSuperClass()            | 获取当前继承的父类名字                 |
| getInstances               | 获取当先类实现的雷或是接口               |

#### 1.3.1.2 获取类中的属性方法
| 方法                            | 用途          |
|-------------------------------|:------------|
| getField(String name)         | 获取某个公有的属性对象 |
| getFields()                   | 获取所有公有的属性对象 |
| getDeclaredField(String name) | 获取某个属性对象    |
| getDeclaredFields()           | 获取所有属性对象    |

#### 1.3.1.3 获取类中方法的方法
| 方法                                                        | 用途          |
|-----------------------------------------------------------|:------------|
| getMethod(String name,Class...<T> parameterTypes)         | 获得该类某个公有的方法 |
| getMethods()                                              | 获得该类所有公有的方法 |
| getDeclaredMethod(String name,Class...<T> parameterTypes) | 获得该类某个方法    |
| getDeclaredMethods()                                      | 获得该类所有方法    |

#### 1.3.1.4 获取类中构造器的方法
| 方法                                                 | 用途                  |
|----------------------------------------------------|:--------------------|
| getConstructor(Class...<T> parameterTypes)         | 获得该类中与参数类型匹配的公有构造方法 |
| getConstructors()                                  | 获得该类的所有公有构造方法       |
| getDeclaredConstructor(Class...<T> parameterTypes) | 获得该类中与参数类型匹配的构造方法   |
| getDeclaredConstructors()                          | 获得该类所有构造方法          |

## 1.3.2 Filed类
| 方法                           | 用途              |
|------------------------------|:----------------|
| equals(Object obj)           | 属性与obj相等则返回true |
| get(Object obj)              | 获得obj中对应的属性值    |
| set(Object obj,Object value) | 设置obj中对应属性值     |

### 1.3.3 Method类
| 方法                                | 用途                      |
|-----------------------------------|:------------------------|
| invoke(Object obj,Object... args) | 传递object对象及参数调用该对象对应的方法 |

### 1.3.4 Constructor类
| 方法                              | 用途 |
|---------------------------------|:--|
| newInstance(Object... initargs) | 根据传递的参数创建类的对象 |




