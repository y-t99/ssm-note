package cn.yuanyuan.practice04.config;

import cn.yuanyuan.practice04.bean.Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author yuanyuan
 * #create 2020-03-13-18:58
 */
@ComponentScan({"cn.yuanyuan.practice04"})
public class MyConfig {
    @Bean
    public Dao dao(){
        Dao dao=new Dao();
        System.out.println("MyConfig"+dao);
        return dao;
    }
}
