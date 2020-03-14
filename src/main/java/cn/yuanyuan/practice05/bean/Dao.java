package cn.yuanyuan.practice05.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yuanyuan
 * #create 2020-03-13-19:09
 */
@Data
public class Dao {
    @Autowired
    Test test;

    public void query(){
        System.out.println("查询");
    }
}
