# 1. JVM字节码指令

## 1.1 JVM中int类型数值采用何种指令入栈的?

```text
/**
 * JVM字节码指令
 * byte、short、char、boolean：都以int型来保存
 */
public class JVMcommand {
    /**
     * JVM中int类型数值采用何种指令入栈的?
     * 根据取值范围将入栈的字节码指令分为4类
     * 1. 取值 -1~5 JVM采用 iconst 指令将常量压入栈中；
     * 例：iconst_0, iconst_1，特殊：-1 是 iconst_m1
     * 2. 取值 -128~127 采用 bipush 指令；
     * 例：bipush -2, bipush 6   （ps:-128 ~ -2, 6 ~ 127）
     * 3. 取值 -32768~32767 采用 sipush 指令；
     * 例：sipush 128    （ps:-32768 ~ -129, 128 ~ 32767）
     * 注:-129对应65407，-130对应65406
     * 4. 取值 -2147483648~2147483647 采用 ldc 指令。
     * （ps:-2147483648 ~ -32769, 32768 ~ 2147483647）
     * 注：ldc指令是从常量池中获取值的，也就是说在这段范围（-2147483648~2147483647）内的int值是存储在常量池中的
     */
    public void testNum() {
        int a = 0;
        int b = 1;
        a = -1;
        a = 2;
        a = -2;
        a = 3;
        a = 4;
        a = 5;
        a = 6;
        a = 127;
        a = -127;
        a = 128;
        a = -128;
        a = 129;
        a = -129;
        a = 130;
        a = -130;
        a = 32767;
        a = 32768;
        a = -32768;
        a = -32769;
    }
}
```

```text
 0 iconst_0     //int a = 0, 0进入操作数栈
 1 istore_1     //将操作数栈的元素存储到局部变量表索引1的位置
 2 iconst_1     //int b = 1, 1进入操作数栈
 3 istore_2     //将操作数栈的元素存储到局部变量表索引2的位置
 4 iconst_m1    //-1
 5 istore_1
 6 iconst_2     //2
 7 istore_1
 8 bipush -2    //-1
10 istore_1
11 iconst_3
12 istore_1
13 iconst_4
14 istore_1
15 iconst_5
16 istore_1
17 bipush 6
19 istore_1
20 bipush 127
22 istore_1
23 bipush -127
25 istore_1
26 sipush 128
29 istore_1
30 bipush -128
32 istore_1
33 sipush 129
36 istore_1
37 sipush 65407
40 istore_1
41 sipush 130
44 istore_1
45 sipush 65406
48 istore_1
49 sipush 32767
52 istore_1
53 ldc #4 <32768>
55 istore_1
56 sipush 32768
59 istore_1
60 ldc #5 <-32769>
62 istore_1
63 return
```