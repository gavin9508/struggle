# 1. Java8新特性

## 1.1 lambda表达式

### 1.1.1 Lambda表达式的基本语法

->  箭头操作符将lambda表达式分成两部分
> 左侧：lambda 表达式的参数列表
> 右侧：lambda 表达式中所需要执行的功能，即 lambda体

语法格式一：无参数，无返回值
> () -> System.out.println("Hello, lambda") 

语法格式二：有一个参数，无返回值
> (c) -> System.out.println(c)

语法格式三：若只有一个参数，小括号可以省略不写
> (c) -> System.out.println(c)

语法格式四：有两个以上的参数，有返回值，并且lambda体中有多条语句
```java
class test{
    public static void main(String[] args) {
        Comparator<Integer> com = (x,y) -> {
            System.out.println("函数式接口"+x+y);
            return Integer.compare(x, y);
        };
    }
}
```

语法格式五：若lambda体中只有一条语句，return 和 大括号 都可以省略不写
> Comparator<Integer> com1 =(x,y) -> Integer.compare(x,y);

语法格式六：lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，

### 1.1.2 Lambda表达式 需要函数是接口的支持
函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以使用@FunctionInterface 修饰
可以检查是否是函数式接口

## 1.2 函数式表达式

## 1.3 方法引用与构造器引用

## 1.4 Stream API

## 1.5 接口中的默认方法与静态方法

## 1.6 新实践日期API

## 1.7 其他新特性