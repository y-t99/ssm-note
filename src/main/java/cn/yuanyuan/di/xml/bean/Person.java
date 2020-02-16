package cn.yuanyuan.di.xml.bean;

/**
 * @author yuanyuan
 * #create 2020-02-16-15:46
 */
public class Person {
    private Dog pet;

    private String name;
    private int age;


    public void setPet(Dog pet) {
        this.pet = pet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pet=" + pet +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
