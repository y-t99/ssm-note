package cn.yuanyuan.practice09;

import cn.yuanyuan.practice09.config.AppConfig;
import cn.yuanyuan.practice09.pojo.Axe;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        final Axe proxy = (Axe)context.getBean("proxy");
        proxy.chop();
    }
}
