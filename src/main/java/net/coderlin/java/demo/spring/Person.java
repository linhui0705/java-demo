package net.coderlin.java.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Title: Person
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-2-7 11:27
 */
public class Person implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean, DisposableBean {
    private String name;

    public Person() {
        System.out.println("******Person()******");
    }

    public String getName() {
        System.out.println("******getName()******");
        return name;
    }

    public void setName(String name) {
        System.out.println("******setName()******");
        this.name = name;
    }

    private void myInit() {
        System.out.println("******myInit()******");
    }

    private void myDestory() {
        System.out.println("******myDestory()******");
    }

    private String beanName;
    private BeanFactory beanFactory;
    private ClassLoader classLoader;

    @Override
    public void setBeanName(String beanName) {
        System.out.println("******BeanNameAware.setBeanName()******");
        this.beanName = beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("******BeanFactoryAware.setBeanFactory()******");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("******BeanFactoryAware.setBeanClassLoader()******");
        this.classLoader = classLoader;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("******DisposableBean.destory()******");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("******InitializingBean.afterPropertiesSet()******");
    }
}
