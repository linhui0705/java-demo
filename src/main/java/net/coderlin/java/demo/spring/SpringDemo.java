package net.coderlin.java.demo.spring;

import org.junit.Test;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Title: SpringDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-2-6 23:54
 */
public class SpringDemo {
    @Test
    public void testCase() {
        Resource resource = new ClassPathResource("spring-beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        System.out.println("++++++Adding BeanPostProcessor");
        //后置处理器
        beanFactory.addBeanPostProcessor(new MyBeanPostPocessor());
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        System.out.println("++++++Start initializing Object person");

        Object person = beanFactory.getBean("person");

        System.out.println("++++++Destroying Object person");
        //bean销毁
        beanFactory.destroySingletons();
        System.out.println(person);
    }
}
