/**
 * @Classname SizeOfAnObject
 * @Description 计算一个对象的大小
 * 需要加 VM Option:
 *     -javaagent: ObjectSize.jar 的绝对路径
 * @Date 2021/7/10 20:25
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.jmm.object;

import top.caolizhi.example.jvm.agent.ObjectSizeAgent;

public class SizeOfAnObject {

    public static void printObjectSize(Object object) {
        System.out.println("Object type: " + object.getClass() +
            ", size: " + ObjectSizeAgent.sizeOf(object) + " bytes.");
    }

    public static void main(String[] args) {
        /** VM Option:（-XX:+UseCompressedClassPointers 默认开启）
         * ① 对象头 8 + 4 = 12 字节
         *     - mark word   8 字节
         *     - class pointer  ** 4 ** 字节
         * ② 实例数据： 0 字节
         *
         * ③ padding： 4 字节
         * =============总共：16 字节==================
         */
        /**VM Option:（-XX:-UseCompressedClassPointers 不开启）
         * ① 对象头 8 + 8 = 16 字节
         *     - mark word   8 字节
         *     - class pointer  ** 8 ** 字节
         * ② 实例数据： 0 字节
         * ③ padding： 0 字节
         * =============总共：16 字节==================
         */
        printObjectSize(new Object());

        /** VM Option:（-XX:+UseCompressedClassPointers 默认开启）
         * ① 对象头 8 + 4 = 12 字节
         *     - mark word   8 字节
         *     - class pointer  ** 4 ** 字节
         * ② 数组长度：4 字节
         * ③ 实例数据： 0 字节
         * ④ padding： 0 字节
         * =============总共：16 字节==================
         */
        /** VM Option:（-XX:-UseCompressedClassPointers 不开启）
         * ① 对象头 8 + 8 = 16 字节
         *     - mark word   8 字节
         *     - class pointer  ** 8 ** 字节
         * ② 数组长度：4 字节
         * ③ 实例数据： 0 字节
         * ④ padding： 4 字节
         * =============总共：24 字节==================
         */
        printObjectSize(new int[]{});

        /** VM Option:（-XX:+UseCompressedClassPointers 默认开启）
         * ① 对象头 8 + 4 = 12 字节
         *     - mark word   8 字节
         *     - class pointer  4 字节
         * ② 实例数据：14 字节
         * ③ padding： 6 字节
         * =============总共：32 字节==================
         */
        /** VM Option:（-XX:-UseCompressedClassPointers 不开启）
         * ① 对象头 8 + 8 = 16 字节
         *     - mark word   8 字节
         *     - class pointer  8 字节
         * ② 实例数据：14 字节
         * ③ padding： 2 字节
         * =============总共：32 字节==================
         */
        printObjectSize(new T());
    }

    private static class T {
                         // 8 mark word
                         // 4 class pointer， -XX:+UseCompressedClassPointers 开启占4字节，未开启8字节
        int id;          // 4
        String name;     // 4  ops = ordinary object pointers， -XX:+UseCompressedOops 引用类型变量的字节大小，开启占4字节，未开启8字节，
        int age;         // 4

        byte b1;         // 1
        byte b2;         // 1
    }
}
