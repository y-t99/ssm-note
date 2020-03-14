package cn.yuanyuan.practice06.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-14-1:35
 */
@Component
public class DaoFactory implements FactoryBean {

    private Dao dao=new Dao();

    @Override
    public Object getObject() throws Exception {
        System.out.println("DaoFactory:"+dao);
        return dao;
    }

    @Override
    public Class<?> getObjectType() {
        return Dao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
