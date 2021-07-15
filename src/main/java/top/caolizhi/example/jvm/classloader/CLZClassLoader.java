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

public class CLZClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("C:/Dev/test/", name.replace(".", "/").concat(".class"));
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fileInputStream.read()) != 0) {
                byteArrayOutputStream.write(b);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            fileInputStream.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) {
        CLZClassLoader clzClassLoader = new CLZClassLoader();
        try {
            Class<?> clazz = clzClassLoader.findClass("top.caolizhi.example.jvm.classloader.Hello");
            Hello o = (Hello) clazz.getDeclaredConstructor().newInstance();
            o.hellWorld();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
