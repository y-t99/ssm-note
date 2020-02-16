package cn.yuanyuan.aop.xml.tx;

/**
 * @author yuanyuan
 * #create 2020-02-16-18:32
 */
public class TransactionManager {

    public void before(){
        System.out.println("进入方法前");
    }

    public void after(){
        System.out.println("方法执行后");
    }

    public void throwMethod(){
        System.out.println("方法发生错误后");
    }

}
