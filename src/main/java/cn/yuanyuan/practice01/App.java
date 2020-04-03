package cn.yuanyuan.practice01;

import cn.yuanyuan.practice01.expt.CustomExpt;
import cn.yuanyuan.practice01.pojo.User;
import cn.yuanyuan.practice01.service.FooService;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) throws CustomExpt {
        GenericXmlApplicationContext context=
                new GenericXmlApplicationContext("practice01.xml");
        final FooService service =context.getBean(FooService.class);
        final JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        service.setJdbcTemplate(jdbcTemplate);
        service.insertUser(new User("han","han"));
    }
}
