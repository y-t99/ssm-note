package cn.yuanyuan.lifecycle.test;

import cn.yuanyuan.lifecycle.bean.Cat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuanyuan
 * #create 2020-02-16-15:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:lifecycle.xml"})
public class Test {
    @Autowired
    Cat cat;

    @org.junit.Test
    public void test(){
        cat.eat();
    }

}
