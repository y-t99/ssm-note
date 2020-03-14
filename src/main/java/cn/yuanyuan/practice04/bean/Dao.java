package cn.yuanyuan.practice04.bean;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:09
 */
public class Dao {
    @Autowired
    Test test;

    public void query(){
        System.out.println("查询");
    }
}
