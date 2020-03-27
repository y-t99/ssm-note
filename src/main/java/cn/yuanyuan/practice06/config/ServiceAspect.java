package cn.yuanyuan.practice06.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

    @Pointcut("execution(String cn.yuanyuan.practice06.service.Service.returnAdvice(..))")
    private void returnAdvicePointcut(){}

    @Pointcut("execution(void cn.yuanyuan.practice06.service.Service.throwAdvice(..))")
    private void throwAdvicePointcut(){}

    @AfterReturning(value = "cn.yuanyuan.practice06.config.ServiceAspect.returnAdvicePointcut() && args(parameter)"
                    ,returning = "retVal")
    public String returnAdivce(String parameter,String retVal){
        System.out.println("参数为："+parameter);
        return "return advice："+retVal;
    }

    @AfterThrowing(value = "cn.yuanyuan.practice06.config.ServiceAspect.throwAdvicePointcut()"
                    ,throwing = "ex")
    public void throwAdvice(Exception ex){
        System.out.println("异常处理："+ex);
    }

    @After("cn.yuanyuan.practice06.config.ServiceAspect.throwAdvicePointcut()" +
            "|| cn.yuanyuan.practice06.config.ServiceAspect.returnAdvicePointcut()")
    public void finalAdvice(){
        System.out.println("方法退出执行");
    }
}
