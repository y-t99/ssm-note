package cn.yuanyuan.practice07.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class ServiceAspect02 {

    @Pointcut("execution(* cn.yuanyuan.practice07.service.Service.*(..))")
    private void pointcut(){

    }

    @Before("cn.yuanyuan.practice07.config.ServiceAspect02.pointcut()")

    public void beforeAdvice02(){
        System.out.println("aop 增强02");
    }
}
