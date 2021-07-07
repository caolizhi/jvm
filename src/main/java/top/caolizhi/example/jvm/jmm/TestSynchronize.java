/**
 * @Classname TestVolatile
 * @Description volatile 的剖析
 * @Date 2021/7/7 21:30
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.jmm;

public class TestSynchronize {

    final Object o = new Object();

    synchronized void m() {

    }

    void n() {
        synchronized (o) {

        }
    }
}
