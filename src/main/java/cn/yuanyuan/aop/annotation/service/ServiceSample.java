package cn.yuanyuan.aop.annotation.service;

import cn.yuanyuan.aop.annotation.dao.DaoSample;
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
