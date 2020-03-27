package cn.yuanyuan.practice05.service;

import cn.yuanyuan.practice05.annotation.Flag;
import org.springframework.stereotype.Component;

@Component("service")
@Flag
public class Service {
    public void service(){
        System.out.println("service");
    }

    @Flag
    public void combiningJoinpoint(){
        System.out.println("Combining Join Point");
    }
}
