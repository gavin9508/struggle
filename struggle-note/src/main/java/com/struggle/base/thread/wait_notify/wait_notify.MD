## 1.关于Object类中的wait()和notify()方法

> wait()和notify()方法不是线程对象的方法，是java中任何一个java对象都有的方法，因为这两个方法是Object类中自带的。
>
> wait()和notify()方法不是通过线程对象调用的。
> 
> wait()和notify()方法建立在synchronized线程同步的基础上。

### 1.1 wait()方法的作用

```text
Object o = new Object();
o.wait();

表示：让正在o对象上活动的线程进入等待状态，无限期等待，知道被唤醒为止。
      o.wait()方法的调用，会让“当前线程（正在o对象上活动的线程）”进入等待状态，并且释放o对象上的锁。
```

### 1.2 notify()方法的作用
```text
Object o = new Object();
o.notify();

表示：唤醒正在o对象上等待的线程
      o.notify()方法只会通知，不会释放之前占有的o对象的锁。
o.notifyAll();
表示：唤醒对象上处于等待的所有线程。
      
```

