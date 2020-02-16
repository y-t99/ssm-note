package cn.yuanyuan.aop.annotation.tx;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:32
 */
@Component
@Aspect
public class TransactionManager {
    @Pointcut("execution(* cn.yuanyuan.aop.annotation.service.Service*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("进入方法前");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("方法执行后");
    }

    @AfterThrowing("pointCut()")
    public void throwMethod() {
        System.out.println("方法发生错误后");
    }

}
