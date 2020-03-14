package cn.yuanyuan.practice04.app;

import cn.yuanyuan.practice04.bean.Dao;
import cn.yuanyuan.practice04.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
        final Dao dao = (Dao) applicationContext.getBean("dao");
        System.out.println("App:"+dao);
        dao.query();
        applicationContext.close();
    }
}
