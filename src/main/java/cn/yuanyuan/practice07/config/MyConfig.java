package cn.yuanyuan.practice07.config;

import cn.yuanyuan.practice07.bean.IMapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @author yuanyuan
 * #create 2020-03-13-18:58
 */
@ComponentScan({"cn.yuanyuan.practice07"})
@IMapperScan
@Configuration
public class MyConfig {
}
