package cn.yuanyuan.practice09.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 增强器
 */
@Component("steelAroundAdvice")
public class SteelAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Before: invocation=[" + invocation + "]");
        Object result = invocation.proceed();
        System.out.println("武器保养");
        return result;
    }

}
