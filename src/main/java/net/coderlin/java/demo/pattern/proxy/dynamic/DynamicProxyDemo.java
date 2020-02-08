package net.coderlin.java.demo.pattern.proxy.dynamic;

import net.coderlin.java.demo.pattern.proxy.UserService;
import net.coderlin.java.demo.pattern.proxy.UserServiceImpl;
import net.coderlin.java.demo.pattern.proxy.dynamic.cglib.CglibProxyFactory;
import net.coderlin.java.demo.pattern.proxy.dynamic.jdk.JdkProxyFactory;
import org.junit.Test;

/**
 * Title: DynamicProxyDemo
 * Description:
 * 动态代理
 *
 * @author Lin Hui
 * Created on 2020-1-31 12:45
 */
public class DynamicProxyDemo {
    @Test
    public void testJdkProxy() {
        UserService userService1 = (UserService) new JdkProxyFactory(new UserServiceImpl()).getProxyInstanceLambda();
        userService1.save();
        System.out.println("----------");
        UserService userService2 = (UserService) new JdkProxyFactory(new UserServiceImpl()).getProxyInstance();
        userService2.save();
    }

    @Test
    public void testCglibProxy() {
        UserService userService = (UserService) new CglibProxyFactory(new UserServiceImpl()).getProxyInstance();
        userService.save();
    }
}
