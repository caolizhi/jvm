/**
 * @Classname ClassLoaderLevel
 * @Description TODO
 * @Date 2021/7/15 21:40
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

public class ClassLoaderLevel {

    /**
     * JDK 8 ：
         String 类的 ClassLoader 是：null
         --------------
         示例类的 ClassLoader 是：sun.misc.Launcher$AppClassLoader@18b4aac2
         示例类的 ClassLoader 的父加载器是：sun.misc.Launcher$ExtClassLoader@2f0e140b
         示例类的 ClassLoader 的 ClassLoader 是：null
         --------------
         系统 ClassLoader 是：sun.misc.Launcher$AppClassLoader@18b4aac2
         系统 ClassLoader 的父加载器是：sun.misc.Launcher$ExtClassLoader@2f0e140b
         系统 ClassLoader 的 ClassLoader 是：null
     */

    /**
     * JDK 11 打印：
         String 类的 ClassLoader 是：null
         --------------
         示例类的 ClassLoader 是：jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
         示例类的 ClassLoader 的父加载器是：jdk.internal.loader.ClassLoaders$PlatformClassLoader@6108b2d7
         示例类的 ClassLoader 的 ClassLoader 是：null
         --------------
         系统 ClassLoader 是：jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
         系统 ClassLoader 的父加载器是：jdk.internal.loader.ClassLoaders$PlatformClassLoader@6108b2d7
         系统 ClassLoader 的 ClassLoader 是：null
     */

    public static void main(String[] args) {
        System.out.println("String 类的 ClassLoader 是：" + String.class.getClassLoader());
        System.out.println("--------------");
        System.out.println("示例类的 ClassLoader 是：" + ClassLoaderLevel.class.getClassLoader());
        System.out.println("示例类的 ClassLoader 的父加载器是：" + ClassLoaderLevel.class.getClassLoader().getParent());
        System.out.println("示例类的 ClassLoader 的 ClassLoader 是：" + ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
        System.out.println("--------------");
        System.out.println("系统 ClassLoader 是：" + ClassLoader.getSystemClassLoader());
        System.out.println("系统 ClassLoader 的父加载器是：" + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("系统 ClassLoader 的 ClassLoader 是：" + ClassLoader.getSystemClassLoader().getClass().getClassLoader());

        System.out.println(System.getProperty("sun.boot.class.path")); //jdk8 打印 rt.jar 的类，jdk11 空
        System.out.println(System.getProperty("java.ext.dirs")); // jdk8 打印 ext 类， jdk11 空
        System.out.println(System.getProperty("java.class.path")); // jdk8 和 jdk 11 都打印 classpath 下的 jar
    }

}
