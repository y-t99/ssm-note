package cn.yuanyuan.practice06.service;

import org.springframework.stereotype.Component;

@Component("service")
public class Service {

    public String returnAdvice(String parameter){
        return "return："+parameter;
    }

    public void throwAdvice(){
        throw new RuntimeException();
    }
}
