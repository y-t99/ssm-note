package cn.yuanyuan.practice07.bean;

import cn.yuanyuan.practice07.handler.MapperInvocationHandle;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @author yuanyuan
 * #create 2020-03-14-1:35
 */
@Component
public class MapperFactory implements FactoryBean {

    Class mapperInterface;

    public MapperFactory(){
        System.out.println("不带参构造函数");
    }

    /**
     * 第二种方式，包扫描
     * @param mapperInterface
     */
    public MapperFactory(Class mapperInterface){
        this.mapperInterface=mapperInterface;
        System.out.println("带参构造函数");
    }

    @Override
    public Object getObject() {
        Class[] clazzs=new Class[]{mapperInterface};
        final Object o = Proxy.newProxyInstance(MapperFactory.class.getClassLoader(), clazzs,
                new MapperInvocationHandle());
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 第一种方式，通过xml
    <bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
      <property name="mapperInterface" value="org.mybatis.spring.sample.mapper.UserMapper" />
      <property name="sqlSessionFactory" ref="sqlSessionFactory" />
    </bean>
    */
    public void setMapperInterface(Class mapperInterface){
        this.mapperInterface=mapperInterface;
    }

}
