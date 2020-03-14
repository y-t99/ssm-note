package cn.yuanyuan.practice02.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:09
 */
@Component
public class Service {

    @Autowired
    Dao dao;

    Test test;

    public Service(){
        System.out.println("构造函数1");
    }
    public Service(Test test){
        System.out.println("构造函数2");
        this.test=test;
    }
    public void setService(Test test){
        System.out.println("set方法");
        this.test=test;
    }
}
