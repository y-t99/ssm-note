package cn.yuanyuan.practice05.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

    @Pointcut("@within(cn.yuanyuan.practice05.annotation.Flag)")
    private void pointcut(){

    }

    @Pointcut("@annotation(cn.yuanyuan.practice05.annotation.Flag)")
    private void pointcut01(){

    }

    @Pointcut("pointcut() && pointcut01()")
    private void combiningPointcut(){}

    @Before("cn.yuanyuan.practice05.config.ServiceAspect.pointcut()")
    public void beforeTypeAdvice(){
        System.out.println("aop @within 类增强");
    }

    @Before("cn.yuanyuan.practice05.config.ServiceAspect.pointcut01()")
    public void beforeMethodAdvice(){
        System.out.println("aop @annotation 方法增强");
    }

    @Before("cn.yuanyuan.practice05.config.ServiceAspect.combiningPointcut()")
    public void before(){
        System.out.println("combining pointcut 增强");
    }
}
