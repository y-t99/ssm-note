package cn.yuanyuan.createbean._factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yuanyuan
 * #create 2020-02-16-14:43
 */
public class CatFB implements FactoryBean<CatB> {
    @Override
    public CatB getObject() throws Exception {
        CatB catB=new CatB();
        return catB;
    }

    @Override
    public Class<?> getObjectType() {
        return CatB.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
