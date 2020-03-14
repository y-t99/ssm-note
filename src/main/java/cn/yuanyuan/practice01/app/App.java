package cn.yuanyuan.practice01.app;

import cn.yuanyuan.practice01.bean.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("cn.yuanyuan.practice01");
        final Service bean = applicationContext.getBean(Service.class);
    }
}
