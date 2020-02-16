package cn.yuanyuan.aop.annotation;

import cn.yuanyuan.aop.annotation.service.ServiceSample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aop_annotation.xml")
public class AppTest {
    @Autowired
    ServiceSample serviceSample;

    @Test
    public void test() {
        serviceSample.select();
    }
    @Test
    public void test1() {
        serviceSample.delete();
    }
}
