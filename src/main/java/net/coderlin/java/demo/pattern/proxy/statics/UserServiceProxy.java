package net.coderlin.java.demo.pattern.proxy.statics;

import net.coderlin.java.demo.pattern.proxy.UserService;

/**
 * Title: UserServiceProxy
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-31 12:02
 */
public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void save() {
        startTransaction();
        target.save();
        commit();
    }

    private void startTransaction() {
        System.out.println("开始事务");
    }

    private void commit() {
        System.out.println("提交事务");
    }
}
