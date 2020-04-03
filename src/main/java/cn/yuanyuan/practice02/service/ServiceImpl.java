package cn.yuanyuan.practice02.service;

import cn.yuanyuan.practice02.dao.Dao;
import cn.yuanyuan.practice02.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Throwable.class)
@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {
    @Autowired
    Dao dao;

    @Override
    public void addAccount(Account account) {
        account.setMidifiedtime(System.currentTimeMillis());
        dao.insert(account);
    }

    @Override
    public void transfer(Account from, Account to, int number) {
        dao.updateBalance(from,-number);
//        事务发生异常，事务回滚
//        int error=1/0;
        dao.updateBalance(to,number);
    }

    @Override
    public Account checkAccount(int id) {
        return dao.queryById(id);
    }

    @Override
    public Account checkAccount(String name) {
        return dao.queryByName(name);
    }
}
