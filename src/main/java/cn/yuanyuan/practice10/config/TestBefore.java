package cn.yuanyuan.practice10.config;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("方法执行前");
    }
}
