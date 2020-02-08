package net.coderlin.java.demo.pattern.proxy.statics;

import net.coderlin.java.demo.pattern.proxy.UserService;
import net.coderlin.java.demo.pattern.proxy.UserServiceImpl;
import org.junit.Test;

/**
 * Title: StaticProxyDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-31 12:05
 */
public class StaticProxyDemo {
    @Test
    public void testStaticProxy() {
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy= new UserServiceProxy(userService);
        userServiceProxy.save();
    }
}
