package cn.yuanyuan.practice04.service;

import cn.yuanyuan.practice04.annotation.Flag;
import org.springframework.stereotype.Component;

@Component("service01")
public class Service01 {
    @Flag
    public void service(){
        System.out.println("service01");
    }
}
