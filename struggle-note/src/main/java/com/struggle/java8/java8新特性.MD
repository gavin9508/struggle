# 1. Java8新特性

## 1.1 lambda表达式

### 1.1.1 Lambda表达式的基本语法

> **->  箭头操作符将lambda表达式分成两部分**
> 
> 左侧：lambda 表达式的参数列表
> 右侧：lambda 表达式中所需要执行的功能，即 lambda体

> **语法格式一：**
> 无参数，无返回值
> 
> () -> System.out.println("Hello, lambda") 

> **语法格式二：**
> 有一个参数，无返回值
> 
> (c) -> System.out.println(c)

> **语法格式三：**
> 若只有一个参数，小括号可以省略不写
> 
> (c) -> System.out.println(c)

> **语法格式四：**
> 有两个以上的参数，有返回值，并且lambda体中有多条语句
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

> **语法格式五：**
> 若lambda体中只有一条语句，return 和 大括号 都可以省略不写
> 
> Comparator<Integer> com1 =(x,y) -> Integer.compare(x,y);

> **语法格式六：**
> lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，

### 1.1.2 Lambda表达式需要函数式接口的支持
> **函数式接口：**
> 接口中只有一个抽象方法的接口，称为函数式接口，可以使用@FunctionInterface修饰可以检查是否是函数式接口

## 1.2 函数式表达式
java8 内置的四大核心函数式接口
> 1. Consumer<T>：消费性接口
         void accept(T,t);
> 2. Supplier<T>:  供给型接口
         T get();
> 3. Function<T,R>：函数型接口
         R apply(T,t);
> 4. Predicate<T>：断言型接口
         boolean test(T t);

![](基本的函数式接口.png)
● 原生特化：这些接口使用原生类型替换掉类型参数。代码如下：
```java
interface LongFunction<R> { R apply(long value); }
interface ToIntFunction<T> { intapplyAsInt(T value); }
interface LongToIntFunction { intapplyAsInt(long value); }
```
● Consumer、Predicate与Function的函数类型都接收单个参数。有接收两个参数的相应接口，代码如下：
```java
interface BiConsumer<T,U> { void accept(T t, U u); }
interface BiFunction<T,U,R> { R apply(T t,U u); }
interface ToIntBiFunction<T,U> { int apply(T t, U u); }
```
● Function 的常见用法要求其参数与结果拥有相同的类型。之前在 List.replaceAll 的参数中已经看到了这一点。我们
可以通过将 Function 的变种特化为相应的 Operator 来达s实现，如下所示：
```java
interface UnaryOperator<T> extends Function<T,T> { //... }
interface BinaryOperator<T> extends BiFunction<T,T,T> { //... }
interface IntBinaryOperator { int applyAsInt(int left, int right); }
```

## 1.3 方法引用与构造器引用

## 1.4 Stream API

## 1.5 接口中的默认方法与静态方法

## 1.6 新实践日期API

## 1.7 其他新特性