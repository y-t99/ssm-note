package cn.yuanyuan.practice01;

import cn.yuanyuan.practice01.config.AppConfig;
import cn.yuanyuan.practice01.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("spring aspectj support use execution demo");
        System.out.println("---------------------------");
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        final Service bean = context.getBean("service", Service.class);
        bean.service();
    }
}
