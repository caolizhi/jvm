/**
 * @Classname HelloGC
 * @Description TODO
 * @Date 2021/7/11 21:44
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.gc;

import java.util.LinkedList;
import java.util.List;

public class HelloGC {

    /**
     * java -XX:+PrintCommandLineFlags HelloGC
     * java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC  HelloGC
     * java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC  HelloGC
     * PrintGCDetails PrintGCTimeStamps PrintGCCauses
     * java -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags HelloGC
     * java -XX:+PrintFlagsInitial 默认参数值
     * java -XX:+PrintFlagsFinal 最终参数值
     * java -XX:+PrintFlagsFinal | grep xxx 找到对应的参数
     * java -XX:+PrintFlagsFinal -version |grep GC
     */
    public static void main(String[] args) {
        System.out.println("HelloGC !");
        List list = new LinkedList<>();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}
