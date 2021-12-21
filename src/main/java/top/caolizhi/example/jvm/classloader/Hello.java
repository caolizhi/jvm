package top.caolizhi.example.jvm.classloader;

public class Hello {

    public void helloClassLoader() {
        System.out.println("hello, class loader: " + this.getClass().getClassLoader());
    }

}