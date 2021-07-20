/**
 * @Classname CacheLinePadding
 * @Description 缓存行对齐
 * @Date 2021/7/20 21:51
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.jmm;

public class CacheLineWithPadding {

    private static class Padding {
        public volatile long p1,p2,p3, p4, p5, p6, p7, p8;
    }


    private static class T extends Padding {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000_000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000_000L; i++) {
                arr[1].x = i;
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long end = System.currentTimeMillis();

        System.out.println(end - start); // 大概 1s 不到
    }

}
