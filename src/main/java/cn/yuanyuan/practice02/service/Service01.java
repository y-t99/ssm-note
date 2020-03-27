package cn.yuanyuan.practice02.service;

import org.springframework.stereotype.Component;

@Component("service01")
public class Service01 {
    public void service(){
        System.out.println("service01");
    }
}
