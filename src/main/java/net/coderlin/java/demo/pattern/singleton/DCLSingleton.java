package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: DCLSingleton
 * Description:
 * 双检锁/双重校验锁
 * 是否Lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:33 下午
 */
public class DCLSingleton {
    /**
     * volatile保证各线程对单例实例对可见性
     */
    private volatile static DCLSingleton INSTANCE = null;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (null == INSTANCE) {
            synchronized (DCLSingleton.class) {
                INSTANCE = new DCLSingleton();
            }
        }
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello DCLSingleton");
    }
}
