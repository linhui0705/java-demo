package net.coderlin.java.demo.pattern.singleton;

/**
 * Title: EnumSingleton
 * Description:
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:42 下午
 */
public enum EnumSingleton {
    /**
     * 单例实例
     */
    INSTANCE;

    public void print() {
        System.out.println("Hello EnumSingleton");
    }
}
