package cn.yuanyuan.createbean.test;


import cn.yuanyuan.createbean._constructor.CatC;
import cn.yuanyuan.createbean._factorybean.CatB;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuanyuan
 * #create 2020-02-16-14:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ioc.xml"})
public class Test {
    @Autowired
    CatC catC;
    @Autowired
    CatB catB;
    @Autowired
    CatB catB_;

    @org.junit.Test
    public void test(){
        System.out.println(catC);
        //factorybean默认是多例
        System.out.println(catB);
        System.out.println(catB_);
    }
}
