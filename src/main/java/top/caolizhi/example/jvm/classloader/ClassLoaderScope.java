/**
 * @Classname ClassLoaderScope
 * @Description jdk9 的 class loader 和 jdk 8 的 class loader 做了更改！！！！！
 * @Date 2021/7/15 21:47
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

public class ClassLoaderScope {

    public static void main(String[] args) {
        // jdk 9 移除了下面的两个 path
//        String pathBoot = System.getProperty("sun.boot.class.path");
//        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));

//        System.out.println("------------------------");
//
//        String pathExt  = System.getProperty("java.app.dirs");
//        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        System.out.println("------------------------");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));

    }

}
