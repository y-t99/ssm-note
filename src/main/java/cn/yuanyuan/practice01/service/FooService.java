package cn.yuanyuan.practice01.service;

import cn.yuanyuan.practice01.expt.CustomExpt;
import cn.yuanyuan.practice01.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

public interface FooService {

    User getUser(String userName);

    User getUser(String userName, String userPassword);

    void insertUser(User user) throws CustomExpt;

    void updateUser(User user);

    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
}
