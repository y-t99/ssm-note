package cn.yuanyuan.practice07;

import cn.yuanyuan.practice07.config.AppConfig;
import cn.yuanyuan.practice07.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("advice order");
        System.out.println("---------------------------");
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        final Service bean = context.getBean("service", Service.class);
        bean.service();
    }
}
