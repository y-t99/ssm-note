package cn.yuanyuan.practice10.config;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        if ("bar".equals(method.getName())){
            System.out.println("bar 方法增强");
            return true;
        }else if ("foo".equals(method.getName())){
            System.out.println("foo 方法不增强");
            return false;
        }
        return false;
    }
}
