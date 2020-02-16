package cn.yuanyuan.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:10
 */
@Component("person")
public class Person {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
