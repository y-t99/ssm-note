package cn.yuanyuan.practice01.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-13-18:59
 */
@Component
public class YuanBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("service");
        beanDefinition.setScope("singleton");
    }
}
