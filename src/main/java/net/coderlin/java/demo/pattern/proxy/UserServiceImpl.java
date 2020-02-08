package net.coderlin.java.demo.pattern.proxy;

/**
 * Title: UserServiceImpl
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-31 12:01
 */
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("用户信息已保存！");
    }
}
