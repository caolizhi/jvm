/**
 * @Classname ParentAndChild
 * @Description 查看各个类的 class loader
 * @Date 2021/7/15 21:36
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

public class ParentAndChild {

    public static void main(String[] args) {
        System.out.println(ParentAndChild.class.getClassLoader());
        System.out.println(ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(ParentAndChild.class.getClassLoader().getParent());
        System.out.println(ParentAndChild.class.getClassLoader().getParent().getParent());
    }

}
