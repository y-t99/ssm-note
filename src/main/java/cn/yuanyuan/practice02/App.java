package cn.yuanyuan.practice02;

import cn.yuanyuan.practice02.config.AppConfig;
import cn.yuanyuan.practice02.pojo.Account;
import cn.yuanyuan.practice02.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        final Service bean = (Service) context.getBean("service");
        /*1、添加两个账号
        bean.addAccount(new Account("yuanyuan",10000));
        bean.addAccount(new Account("taotao",5000));
        */

        /*2、转账并查看账号信息*/
        Account account01 = bean.checkAccount(1);
        Account account02 = bean.checkAccount("taotao");
        System.out.println("----------转账前-----------");
        System.out.println(account01);
        System.out.println(account02);
        bean.transfer(account01,account02,1000);
        account01 = bean.checkAccount(1);
        account02 = bean.checkAccount("taotao");
        System.out.println("----------转账后-----------");
        System.out.println(account01);
        System.out.println(account02);
    }
}
