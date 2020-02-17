package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: HungrySingleton
 * Description:
 * 饿汉式
 * 是否Lazy初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:29 下午
 */
public class HungrySingleton {
    private static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    public void print() {
        System.out.println("Hello HungrySingleton");
    }
}
