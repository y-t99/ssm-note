package cn.yuanyuan.practice09.config;

import cn.yuanyuan.practice09.pojo.Axe;
import cn.yuanyuan.practice09.pojo.SteelAxe;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.yuanyuan.practice09")
public class AppConfig {

    /**
     * 获得一个代理对象proxy
     * @param steelAxe
     * @return
     * @throws ClassNotFoundException
     */
    @Bean("proxy")@Autowired
    public Object setProxySteelAxe(SteelAxe steelAxe) throws ClassNotFoundException {
        //代理工厂。工厂模式：简化对象创建，我们只需要通过设置需要的参数，其他的参数由工厂默认设置。
        ProxyFactoryBean proxyFactoryBean=new ProxyFactoryBean();
        //被代理对象。
        proxyFactoryBean.setTarget(steelAxe);
        //代理接口。
        Class[] clazzes=new Class[]{Axe.class} ;
        proxyFactoryBean.setProxyInterfaces(clazzes);
        //增强器。
        proxyFactoryBean.setInterceptorNames("steelAroundAdvice");
        //设置完参数后，getObject()，获取一个代理对象。
        return proxyFactoryBean.getObject();
    }

}
