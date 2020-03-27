package cn.yuanyuan.practice07.service;

import org.springframework.stereotype.Component;

@Component("service")
public class Service {
    public void service(){
        System.out.println("service");
    }
}
