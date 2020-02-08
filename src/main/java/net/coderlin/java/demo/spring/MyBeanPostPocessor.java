package net.coderlin.java.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Title: MyBeanPostPocessor
 * Description:
 * 自定义后置处理器
 * 实例化、依赖注入完毕后的相关操作
 *
 * @author Lin Hui
 * Created on 2020-2-7 11:24
 */
public class MyBeanPostPocessor implements BeanPostProcessor {
    /**
     * 初始化对象前完成一些定制的初始化任务
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======MyBeanPostPocessor.postProcessBeforeInitialization======");
        return bean;
    }

    /**
     * 初始化对象完毕后执行的方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("======MyBeanPostPocessor.postProcessAfterInitialization======");
        return bean;
    }
}
