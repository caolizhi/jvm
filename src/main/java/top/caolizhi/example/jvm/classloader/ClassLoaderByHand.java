/**
 * @Classname ClassLoaderByHand
 * @Description 手动 load class
 * @Date 2021/7/15 22:13
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

public class ClassLoaderByHand {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = ClassLoaderByHand.class.getClassLoader().loadClass("top.caolizhi.example.jvm.classloader.ClassLoaderLevel");
        System.out.println(clazz.getName());

        // ClassLoaderByHand.class.getClassLoader().getResourceAsStream("")
    }

}
