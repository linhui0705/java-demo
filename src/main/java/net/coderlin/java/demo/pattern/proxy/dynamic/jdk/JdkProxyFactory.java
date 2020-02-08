package net.coderlin.java.demo.pattern.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: JdkProxyFactory
 * Description:
 * JDK动态代理，目标类必须实现某个接口，否则不能生成代理对象
 *
 * @author Lin Hui
 * Created on 2020-1-31 12:41
 */
public class JdkProxyFactory {
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * Java8语法
     *
     * @return
     */
    public Object getProxyInstanceLambda() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开始事务");
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务");
                    return returnValue;
                });
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务");
                        return returnValue;
                    }
                });
    }
}
