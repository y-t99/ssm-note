package cn.yuanyuan.practice02.dao;


import cn.yuanyuan.practice02.pojo.Account;

public interface Dao {

    void insert(Account account);

    void updateBalance(Account account, int number);

    Account queryById(int id);

    Account queryByName(String name);
}
