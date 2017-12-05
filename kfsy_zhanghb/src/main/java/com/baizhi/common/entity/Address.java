package com.baizhi.common.entity;

public class Address {
    private String id;
    private String address;
    private String name;
    private String sex;
    private String addr;//小区
    private String userid;

    public Address() {
    }

    public Address(String id, String address, String name, String sex, String addr, String userid) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.sex = sex;
        this.addr = addr;
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", addr='" + addr + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
