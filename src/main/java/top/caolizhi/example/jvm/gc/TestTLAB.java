/**
 * @Classname TestTLAB
 * @Description 测试线程本地分配 TLAB（Thread Local Allocation Buffer）
 * 首先默认直接运行 main，然后关闭一下参数运行
 * -XX:-DoEscapeAnalysis   关闭逃逸分析
 * -XX:-EliminateAllocations 关闭标量替换
 * -XX:-UseTLAB  关闭线程专有对象分配
 *
 * @Date 2021/7/10 23:10
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.gc;

public class TestTLAB {

    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    void allocation(int i) {
        new User(i, "name" + i);
    }

    public static void main(String[] args) {
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            t.allocation(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
