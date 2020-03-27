package cn.yuanyuan.practice05;

import cn.yuanyuan.practice05.config.AppConfig;
import cn.yuanyuan.practice05.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("spring aspectj support use @within @annotation demo");
        System.out.println("---------------------------");
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        final Service bean = context.getBean("service", Service.class);
        bean.service();
        System.out.println("-------------");
        bean.combiningJoinpoint();
    }
}
