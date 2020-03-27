package cn.yuanyuan.practice08.pojo;

public class SimplePojo implements Pojo{
    @Override
    public void foo() {
        this.bar();
    }
    @Override
    public void bar() {
        System.out.println("bar");
    }
}
