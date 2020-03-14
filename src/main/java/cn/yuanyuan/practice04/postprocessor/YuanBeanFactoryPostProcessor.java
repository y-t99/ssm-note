package cn.yuanyuan.practice04.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-13-18:59
 */
@Component
public class YuanBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition= null;
        try {
            beanDefinition = beanFactory.getBeanDefinition("dao");
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("没有dao");
        }
        System.out.println(beanDefinition);
    }
}
