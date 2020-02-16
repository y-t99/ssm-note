package cn.yuanyuan.lifecycle.bean;

/**
 * @author yuanyuan
 * #create 2020-02-16-15:23
 */
public class Cat {
    public Cat(){
        System.out.println("constructor");
    }

    public void init(){
        System.out.println("init method");
    }

    public void destroy(){
        System.out.println("destroy method");
    }
    public void eat(){
        System.out.println("eat something");
    }
}
