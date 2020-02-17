package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: LazySafeSingleton
 * Description:
 * 懒汉式，线程不安全
 * 是否Lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:24 下午
 */
public class LazySafeSingleton {
    private static LazySafeSingleton INSTANCE = null;

    private LazySafeSingleton() {
    }

    public static synchronized LazySafeSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazySafeSingleton();
        }
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello LazySafeSingleton");
    }
}
