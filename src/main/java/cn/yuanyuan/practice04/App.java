package cn.yuanyuan.practice04;

import cn.yuanyuan.practice04.config.AppConfig;
import cn.yuanyuan.practice04.service.Service;
import cn.yuanyuan.practice04.service.Service01;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("spring aspectj support use @within @annotation demo");
        System.out.println("---------------------------");
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        final Service bean = context.getBean("service", Service.class);
        bean.service();
        final Service01 bean01 = context.getBean("service01", Service01.class);
        bean01.service();
    }
}
