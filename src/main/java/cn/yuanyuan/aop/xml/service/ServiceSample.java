package cn.yuanyuan.aop.xml.service;

import cn.yuanyuan.aop.xml.dao.DaoSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:33
 */
@Service
public class ServiceSample {
    @Autowired
    DaoSample dao;

    public void select(){
        dao.select();
    }

    public void delete(){
        dao.delete();
    }
}
