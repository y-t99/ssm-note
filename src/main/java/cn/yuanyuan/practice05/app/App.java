package cn.yuanyuan.practice05.app;

import cn.yuanyuan.practice05.bean.Dao;
import cn.yuanyuan.practice05.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
        final Dao dao = new Dao();
        System.out.println("放入前"+dao);
        applicationContext.getBeanFactory().registerSingleton("dao",dao);
        System.out.println("放入后"+applicationContext.getBean(Dao.class));
    }
}
