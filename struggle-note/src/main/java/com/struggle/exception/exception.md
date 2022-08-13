# 异常处理
异常是指中断程序正常执行的一个不确定的事件。

![](./img/异常.png)

## 1.Exception 和 Error
**Error**：Error 属于程序无法处理的错误。

**Exception**：程序本身可以处理的异常，可以通过 catch 来进行捕获。

## 2.Checked 和 Unchecked
**Checked Exception**：受检查异常；Java 代码在编译过程中，如果异常没有被 catch或者throws 关键字处理的话，就没办法通过编译。

**Unchecked Exception**：不受检查异常。运行时异常，即使不处理不受检查异常也可以正常通过编译。

## 3.throw 和 throws

**throw**：用于主动地抛出异常。

**throws**：对于检查型异常，使用 throws 关键字来声明。

## 4.try-catch-finally
* try： 用于捕获异常。其后接0-n个catch，如果没有catch，则必须跟一个 finally。
* catch：用于处理 try 捕获到的异常。
* finally：无论是否捕获或处理异常，finally 块里的语句都会被执行。

**注：当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行。**

## 5.try-with-resouces 
JDK7 之后，Java 新增的 try-with-resource 语法糖来打开资源，并且可以在语句执行完毕后确保每个资源都被自动关闭。多个资源使用；隔开。

    try(要释放的资源){

    }catch(IOException e){

    }
### AutoCloseable 类
需要释放的资源实现 AutoCloseable 接口就可以支持try-with-resouces 语法了。

    public interface Closeable extends AutoCloseable {
    
        /**
         * Closes this stream and releases any system resources associated
         * with it. If the stream is already closed then invoking this
         * method has no effect.
         *
         * <p> As noted in {@link AutoCloseable#close()}, cases where the
         * close may fail require careful attention. It is strongly advised
         * to relinquish the underlying resources and to internally
         * <em>mark</em> the {@code Closeable} as closed, prior to throwing
         * the {@code IOException}.
         *
         * @throws IOException if an I/O error occurs
         */
        public void close() throws IOException;
    }
