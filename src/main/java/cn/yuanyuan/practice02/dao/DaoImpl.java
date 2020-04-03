package cn.yuanyuan.practice02.dao;

import cn.yuanyuan.practice02.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Account account) {
        String sql="INSERT INTO t_account(username, balance, modifiedtime) VALUES(?,?,?)";
        jdbcTemplate.update(sql,account.getUsername(),account.getBalance(),account.getMidifiedtime());
    }

    @Override
    public void updateBalance(Account account, int number) {
        String sql="UPDATE t_account SET balance=balance+? WHERE id=?";
        jdbcTemplate.update(sql,number,account.getUserId());
    }


    @Override
    public Account queryById(int id) {
        String sql="SELECT id,username,balance,modifiedtime FROM t_account " +
                "  WHERE id=? ";
        return jdbcTemplate.queryForObject(sql,(resultSet, rowNum) -> {
            Account account = new Account(resultSet.getString("username")
                                ,resultSet.getInt("balance"));
            account.setUserId(resultSet.getInt("id"));
            account.setMidifiedtime(resultSet.getLong("modifiedtime"));
            return account;
        },id);
    }

    @Override
    public Account queryByName(String name) {
        String sql="SELECT id,username,balance,modifiedtime FROM t_account " +
                "  WHERE username=? ";
        return jdbcTemplate.queryForObject(sql,(resultSet, rowNum) -> {
            Account account = new Account(resultSet.getString("username")
                    ,resultSet.getInt("balance"));
            account.setUserId(resultSet.getInt("id"));
            account.setMidifiedtime(resultSet.getLong("modifiedtime"));
            return account;
        },name);
    }
}
