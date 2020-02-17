package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: StaticInnerClassSingleton
 * Description:
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
