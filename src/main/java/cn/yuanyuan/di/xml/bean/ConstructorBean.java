package cn.yuanyuan.di.xml.bean;

/**
 * @author yuanyuan
 * #create 2020-02-16-16:29
 */
public class ConstructorBean {
    private String parameter1;
    private int parameter2;
    private int parameter3;

    public ConstructorBean(String parameter1, int parameter2, int parameter3) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
    }

    @Override
    public String toString() {
        return "ConstructorBean{" +
                "parameter1='" + parameter1 + '\'' +
                ", parameter2=" + parameter2 +
                ", parameter3=" + parameter3 +
                '}';
    }
}
