package cn.yuanyuan.practice07.bean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-14-2:27
 */
@Configuration
public class ImportBeanDefinitionRegistrat implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //mapper包下所有类，将其用工厂生产出来，并注册到spring容器中
        //for 假设只有一个Dao接口
        final BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MapperFactory.class);
        final GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        //构造函数注入
        beanDefinition.setAutowireMode(3);
        //添加构造函数值
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("cn.yuanyuan.practice07.bean.Dao");
        //将beanDefinition注册到spring容器中
        registry.registerBeanDefinition("dao",beanDefinition);
    }
}
