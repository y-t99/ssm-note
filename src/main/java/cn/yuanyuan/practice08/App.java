package cn.yuanyuan.practice08;

import cn.yuanyuan.practice08.pojo.Pojo;
import cn.yuanyuan.practice08.pojo.SimplePojo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        //spring aop 自调用问题
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("advice");
            }
        });

        Pojo pojo = (Pojo) factory.getProxy();
        // this is a method call on the proxy!
        pojo.foo();
        System.out.println("----------------------------");
        pojo.bar();
    }
}
