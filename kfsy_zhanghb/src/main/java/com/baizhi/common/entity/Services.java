package com.baizhi.common.entity;

public class Services {
    private String id;
    private String name;
    private Integer count;
    public Services() {
    }

    public Services(String id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
