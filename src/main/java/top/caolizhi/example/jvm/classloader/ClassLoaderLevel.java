/**
 * @Classname ClassLoaderLevel
 * @Description TODO
 * @Date 2021/7/15 21:40
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

public class ClassLoaderLevel {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());  // null -> boot class loader
        System.out.println(sun.reflect.ReflectionFactory.class.getClassLoader()); // null -> boot class loader
        System.out.println(ClassLoaderLevel.class.getClassLoader()); // jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
        System.out.println(ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader()); // null
    }

}
