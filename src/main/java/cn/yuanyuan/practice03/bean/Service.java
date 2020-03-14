package cn.yuanyuan.practice03.bean;

import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:09
 */
@Component
public class Service {

    Dao dao;

    Test test;

    public Service(){
        System.out.println("构造函数1");
    }
    public Service(Dao dao){
        System.out.println("构造函数2");
        this.dao=dao;
    }

    public void setTest(Test test){
        System.out.println("set方法");
        this.test=test;
    }
}
