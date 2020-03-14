package cn.yuanyuan.practice07.app;

import cn.yuanyuan.practice07.bean.Dao;
import cn.yuanyuan.practice07.config.MyConfig;
import lombok.val;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author yuanyuan
 * #create 2020-03-13-19:10
 */

public class App {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MyConfig.class);
        final Dao dao = applicationContext.getBean(Dao.class);
        dao.query();
    }
}
