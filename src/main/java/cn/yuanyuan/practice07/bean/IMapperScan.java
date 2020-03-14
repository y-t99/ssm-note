package cn.yuanyuan.practice07.bean;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author yuanyuan
 * #create 2020-03-14-2:24
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(ImportBeanDefinitionRegistrat.class)
public @interface IMapperScan {
}
