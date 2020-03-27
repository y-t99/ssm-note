package cn.yuanyuan.practice07.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ServiceAspect01 {

    @Pointcut("execution(* cn.yuanyuan.practice07.service.Service.*(..))")
    private void pointcut(){

    }

    @Before("cn.yuanyuan.practice07.config.ServiceAspect01.pointcut()")

    public void beforeAdvice01(){
        System.out.println("aop 增强01");
    }


}
