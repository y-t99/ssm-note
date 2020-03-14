package cn.yuanyuan.practice07.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuanyuan
 * #create 2020-03-13-23:37
 */
public class MapperInvocationHandle implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理Dao接口");
        return null;
    }
}
