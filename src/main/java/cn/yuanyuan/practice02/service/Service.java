package cn.yuanyuan.practice02.service;

import cn.yuanyuan.practice02.pojo.Account;

public interface Service {
    void addAccount(Account account);

    void transfer(Account from,Account to, int number);

    Account checkAccount(int id);

    Account checkAccount(String name);
}
