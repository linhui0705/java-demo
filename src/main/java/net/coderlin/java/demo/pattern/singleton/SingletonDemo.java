package net.coderlin.java.demo.pattern.singleton;

import org.junit.Test;

/**
 * Title: SingletonDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020/2/17 10:18 下午
 */
public class SingletonDemo {
    @Test
    public void testCase() {
        LazyUnsafeSingleton lazyUnsafeSingleton = LazyUnsafeSingleton.getInstance();
        lazyUnsafeSingleton.print();

        LazySafeSingleton lazySafeSingleton = LazySafeSingleton.getInstance();
        lazySafeSingleton.print();

        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        hungrySingleton.print();

        DCLSingleton dclSingleton = DCLSingleton.getInstance();
        dclSingleton.print();

        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
        staticInnerClassSingleton.print();

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.print();
    }
}
