package cn.yuanyuan.practice10.pojo;

public class SimplePojo implements Pojo {
    @Override
    public void foo() {
        System.out.println("foo");
    }
    @Override
    public void bar() {
        System.out.println("bar");
    }
}
