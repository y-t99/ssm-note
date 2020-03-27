package cn.yuanyuan.practice10;

import cn.yuanyuan.practice10.config.TestBefore;
import cn.yuanyuan.practice10.config.TestInterceptor;
import cn.yuanyuan.practice10.config.TestPointcut;
import cn.yuanyuan.practice10.pojo.Pojo;
import cn.yuanyuan.practice10.pojo.SimplePojo;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;


public class App {
    public static void main(String[] args) {
        //spring aop ProxyFactory
        //定义一个增强器
        DefaultPointcutAdvisor advisor=new DefaultPointcutAdvisor();
        advisor.setPointcut(new TestPointcut());
        advisor.setAdvice(new TestInterceptor());
        ProxyFactory factory = new ProxyFactory();
        //1、设置被代理对象
        factory.setTarget(new SimplePojo());
        //2、设置接口
        factory.setInterfaces(Pojo.class);
        //3、设置增强器
        factory.addAdvisor(advisor);
        //4、对全部方法设置增强
        factory.addAdvice(new TestBefore());
        //5、获取代理对象
        final Pojo proxy = (Pojo) factory.getProxy();
        proxy.bar();
        System.out.println("-------------------");
        proxy.foo();
    }
}
