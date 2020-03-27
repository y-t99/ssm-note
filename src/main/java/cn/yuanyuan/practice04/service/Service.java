package cn.yuanyuan.practice04.service;

import cn.yuanyuan.practice04.annotation.Flag;
import org.springframework.stereotype.Component;

@Component("service")
@Flag
public class Service {
    public void service(){
        System.out.println("service");
    }
}
