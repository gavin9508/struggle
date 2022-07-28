package com.struggle.object.GC;

/**
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:./gc.log
 *
 * 为了更清晰的查看各个区的垃圾回收情况，可以使用jstat命令
 * jstat -gc <pid> <period> <count>  来监控垃圾回收
 *     （pid为Java进程的id，period指每次监控之间的时间间隔(s)，count指监控次数）
 */
public class GCDemo1 {
    public static void main(String[] args) {
        String str = "abc";
        while (true){
            str = str.concat("abc");
        }
    }
}
