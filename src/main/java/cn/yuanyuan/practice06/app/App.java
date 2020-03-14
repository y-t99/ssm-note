package cn.yuanyuan.practice06.app;

import cn.yuanyuan.practice06.bean.Dao;
import cn.yuanyuan.practice06.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */
public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
        final Dao dao = applicationContext.getBean(Dao.class);
        System.out.println("App:"+dao);
    }
}
