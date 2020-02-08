package net.coderlin.java.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

/**
 * Title: MyInstantiationAwareBeanPostProcessor
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-2-7 11:26
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.predictBeanType------");
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.determineCandidateConstructors------");
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.getEarlyBeanReference------");
        return super.getEarlyBeanReference(bean, beanName);
    }

    /**
     * 实例化Bean前调用
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation------");
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 1.实例化Bean后调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation------");
        return super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 对象参数set入参数
     *
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessProperties------");
        return super.postProcessProperties(pvs, bean, beanName);
    }

    /**
     * 设置某个属性调用
     *
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessPropertyValues------");
        return super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }

    /**
     * 初始化前调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessBeforeInitialization------");
        return super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化后调用
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("----->MyInstantiationAwareBeanPostProcessor.postProcessAfterInitialization------");
        return super.postProcessAfterInitialization(bean, beanName);
    }
}
