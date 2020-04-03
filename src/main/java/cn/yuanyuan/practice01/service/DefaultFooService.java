package cn.yuanyuan.practice01.service;

import cn.yuanyuan.practice01.expt.CustomExpt;
import cn.yuanyuan.practice01.pojo.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class DefaultFooService implements FooService{
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUser(String userName) {
        return null;
    }

    @Override
    public User getUser(String userName, String userPassword) {
        return null;
    }

    @Override
    public void insertUser(User user){

        String sql="INSERT INTO t_user(user_name,user_password) VALUES(?,?)";
        jdbcTemplate.update(sql,user.getUserName(),user.getUserPassword());

        /*
        发生运行时异常，事务将回滚
        int result=1/0;
        */
        /*
        声明式异常时，事务将不回滚
        throw new CustomExpt();
        */

        try {
            throw new CustomExpt();
        } catch (CustomExpt customExpt) {
            throw new RuntimeException();
        }
    }

    @Override
    public void updateUser(User user) {

    }
}
