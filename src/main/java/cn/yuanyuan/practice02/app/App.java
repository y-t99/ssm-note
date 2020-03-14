package cn.yuanyuan.practice02.app;

import cn.yuanyuan.practice02.bean.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("cn.yuanyuan.practice02");
        final Service bean = applicationContext.getBean(Service.class);
    }
}
