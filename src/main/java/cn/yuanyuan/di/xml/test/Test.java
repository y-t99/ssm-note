package cn.yuanyuan.di.xml.test;


import cn.yuanyuan.di.xml.bean.CollectionBean;
import cn.yuanyuan.di.xml.bean.ConstructorBean;
import cn.yuanyuan.di.xml.bean.Person;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuanyuan
 * #create 2020-02-16-15:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:di.xml"})
public class Test {
    @Autowired
    Person person;

    @Autowired
    CollectionBean collectionBean;

    @Autowired
    ConstructorBean constructorBean;
    @org.junit.Test
    public void test(){
        System.out.println(person);
        System.out.println(collectionBean);
        System.out.println(constructorBean);
    }

}
