package cn.yuanyuan.practice03.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

    @Pointcut("within(cn.yuanyuan.practice03.service.*)")
    private void pointcut(){

    }

    @Before("cn.yuanyuan.practice03.config.ServiceAspect.pointcut()")
    public void beforeAdvice(){
        System.out.println("aop 增强");
    }

}
