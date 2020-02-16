package cn.yuanyuan.di.xml.bean;

import java.util.*;

/**
 * @author yuanyuan
 * #create 2020-02-16-16:04
 */
public class CollectionBean {
    private Set<String> set;
    private List<String> list;
    private String[] array;
    private Map<String,Object> map;
    private Properties properties;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "set=" + set +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
