package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: LazyUnsafeSingleton
 * Description:
 * 懒汉式，线程不安全
 * 是否Lazy初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:15 下午
 */
public class LazyUnsafeSingleton {
    private static LazyUnsafeSingleton INSTANCE = null;

    private LazyUnsafeSingleton() {
    }

    public static LazyUnsafeSingleton getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LazyUnsafeSingleton();
        }
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello LazyUnsafeSingleton");
    }
}
