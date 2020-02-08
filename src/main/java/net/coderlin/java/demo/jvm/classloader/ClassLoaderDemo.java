package net.coderlin.java.demo.jvm.classloader;

import org.junit.Test;
import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * Title: ClassLoaderDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:09
 */
public class ClassLoaderDemo {
    @Test
    public void testClassLoader() {
        Object object = new Object();
        //Bootstrap 根类加载器
        ClassLoader classLoader = object.getClass().getClassLoader();
        System.out.println(classLoader);

        try {
            DNSNameService dnsNameService = new DNSNameService();
            //ExtClassLoader 扩展类加载器
            ClassLoader classLoader1 = dnsNameService.getClass().getClassLoader();
            System.out.println(classLoader1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //AppClassLoader 系统类加载器
        ClassLoader classLoader2 = this.getClass().getClassLoader();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader3);
        ClassLoader parentLoader = classLoader3.getParent();
        System.out.println(parentLoader);
        //ExtClassLoader
        ClassLoader grandParentLoader = parentLoader.getParent();
        //null Bootstrap
        System.out.println(grandParentLoader);
        //根类加载器再往上走，就没有父类加载器了，null对象调用对象方法会抛出NPE
        //System.out.println(grandParentLoader.getParent());
    }
}
