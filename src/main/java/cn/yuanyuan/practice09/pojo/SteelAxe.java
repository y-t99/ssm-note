package cn.yuanyuan.practice09.pojo;

import org.springframework.stereotype.Component;

/**
 * target对象，即需要被代理的对象
 */
@Component("steelAxe")
public class SteelAxe implements Axe {
    @Override
    public void chop() {
        System.out.println("用铁斧砍柴。");
    }
}

