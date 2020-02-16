package cn.yuanyuan.aop.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:33
 */
@Repository
public class DaoSample {

    public void select(){
        System.out.println("查找开始");
        System.out.println("查找完成");
    }

    public void delete(){
        System.out.println("删除开始");
        throw new RuntimeException("发生错误");
    }

}
