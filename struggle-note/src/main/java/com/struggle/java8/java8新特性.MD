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
```
Comparator<Integer> com = (x,y) -> {
    System.out.println("函数式接口"+x+y);
    return Integer.compare(x, y);
};
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
interface UnaryOperator<T> extends Function<T,T> { }
interface BinaryOperator<T> extends BiFunction<T,T,T> { }
interface IntBinaryOperator { int applyAsInt(int left, int right); }
```

## 1.3 方法引用与构造器引用
一般来说，任何 lambda 表达式都可以看作声明在函数式接口中的单个抽象方法的实现。不过，当 lambda 表达
式只是调用现有类中的具名方法的一种方式时，编写 lambda 的更好方式则是使用已有的名字。例如，考虑如下代码，它会向控制台输出列表中的每个元素：
```
pointList.forEach(s -> System.out.print(s));
```
这里的 lambda 表达式只是将参数传递给 print 调用。诸如此类的 lambda(其唯一目的就是将参数提供给一个具体方法)完全是由该方法类型定义的。
因此，假如可以通过某种方式确定出类型，那么只包含方法名的简短形式所提供的信息就与完整的lambda表达式一样，但可读性会更好。相比于上述代码，我们可以这样编写：
```
pointList.forEach(System.out::print);
```
它表示相同的含义。这种对现有类的具体方法的操作写法称为方法引用。有 4 种类型的方法引用，如下表所示。

| 名字    | 语法                    | 相应的lambda表达式                       |
|-------|:----------------------|------------------------------------|
| 静态    | RefType::staticMethod | （args)->RefType.staticMethod(args) |
| 绑定实例  | expr::instMethod      | (args)->  expr.instMethod(args)    |
| 未绑定实例 | RefType::instMethod   | (args)->RefType.instMethod(args)   |
| 构造器   | ClsName::new          | (args)->new ClsName(args)          |

### 1.3.1 静态方法的引用
静态方法引用的语法只需要类与静态方法名，中间通过两个冒号分隔。例如：
```
String::valueOf
Integer::compare
```
是对静态方法的引用。为假设我们想要根据大小对一个 Integer 数组排序，数组中的每个值都被看成无符号的。Integer 的自然顺序根据数字来排序(也就是考虑到值
的符号)，因此我们需要提供一个显式的 Comparator。我们可以使用静态方法 Integer.compareUnsigned：
```
(x,y) -> Integer.compareUnsigned(x, y);
```
这样，对数组 integerArray 排序就可以调用：
```
Arrays.sort(integerArray, (x,y) -> Integer.compareUnsigned(x,y));
```
这是合法的，不过这么做要比相应的静态方法引用冗长和重复：
```
Arrays.sort(integerArray, Integer::compareUnsigned);
```
>这里要注意一点的是，你需要引入的方法的参数列表和返回值，
以及实现内容，必须和lambda将要实现的抽象方法的参数列表、返回值和实现内容一致；

## 1.4 Stream API

## 1.5 接口中的默认方法与静态方法

## 1.6 新实践日期API

## 1.7 其他新特性