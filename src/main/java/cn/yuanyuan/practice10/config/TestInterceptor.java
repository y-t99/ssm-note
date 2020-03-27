package cn.yuanyuan.practice10.config;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("方法增强");
        //对象获取
        final Object target = invocation.getThis();
        System.out.println("对象："+target);
        //方法执行
        final Object result = invocation.proceed();
        return result;
    }
}
