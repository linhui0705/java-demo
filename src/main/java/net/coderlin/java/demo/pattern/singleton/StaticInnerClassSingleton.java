package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: StaticInnerClassSingleton
 * Description:
 * 登记式/静态内部类
 * 是否Lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:47 下午
 */
public class StaticInnerClassSingleton {
    private static class SingletonHandler {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHandler.INSTANCE;
    }

    public void print() {
        System.out.println("Hello StaticInnerClassSingleton");
    }
}
