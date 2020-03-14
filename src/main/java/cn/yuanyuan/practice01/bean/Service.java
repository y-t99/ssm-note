package cn.yuanyuan.practice01.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:09
 */
@Component
@Scope("prototype")
public class Service {

    @Autowired
    Dao dao;

}
