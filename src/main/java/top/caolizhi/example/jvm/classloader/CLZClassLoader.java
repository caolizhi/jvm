/**
 * @Classname CLZClassLoader
 * @Description 自定义 class loader
 * @Date 2021/7/15 22:41
 * @Created by 宝子哥
 */
package top.caolizhi.example.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CLZClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // File f = new File("C:/Users/Administrator/Desktop", name.replace(".", "/").concat(".class"));
        File f = new File("E:/Workspaces/Git/caolizhi-personal/jvm/target/classes/", name.replace(".", "/").concat(".class"));
        Class<?> clazz = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b;
            while ((b = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(b);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            fileInputStream.close();
            clazz = defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static void main(String[] args) {
        CLZClassLoader clzClassLoader = new CLZClassLoader();
        try {
            System.out.println("系统类加载器：");
            Class<?> clazz1 = clzClassLoader.loadClass("top.caolizhi.example.jvm.classloader.Hello");
            Hello hello = (Hello) clazz1.newInstance();
            hello.helloClassLoader();
            System.out.println("=====================================================================");
            System.out.println("自定义类加载器：");
            Class<?> clazz = clzClassLoader.findClass("top.caolizhi.example.jvm.classloader.Hello");
            Object o = clazz.getDeclaredConstructor().newInstance();
            // Hello o = (Hello) clazz.getDeclaredConstructor().newInstance(); // 强转就会报错，因为不是同一个类加载器加载的，JVM 认为不是同一个类。
            // o.helloClassLoader();
            Method method = clazz.getDeclaredMethod("helloClassLoader");
            method.invoke(o,null);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
