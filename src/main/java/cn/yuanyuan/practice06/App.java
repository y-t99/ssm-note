package cn.yuanyuan.practice06;

import cn.yuanyuan.practice06.config.AppConfig;
import cn.yuanyuan.practice06.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfig.class);
        final Service service = context.getBean("service", Service.class);
        System.out.println("test after running and parameter");
        final String returnAdvice = service.returnAdvice("parameter");
        System.out.println(returnAdvice);
        System.out.println("---------------------------");
        System.out.println("test throw exception");
        service.throwAdvice();
    }
}
