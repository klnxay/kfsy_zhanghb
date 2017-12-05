package com.baizhi.common.entity;

//优惠券
public class PriviUser {
    private String id;
    private String priviid;
    private Integer num;
    private String userid;
    private String state;
    public PriviUser() {
    }

    public PriviUser(String id, String priviid, Integer num, String userid, String state) {
        this.id = id;
        this.priviid = priviid;
        this.num = num;
        this.userid = userid;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriviid() {
        return priviid;
    }

    public void setPriviid(String priviid) {
        this.priviid = priviid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "PriviUser{" +
                "id='" + id + '\'' +
                ", priviid='" + priviid + '\'' +
                ", num=" + num +
                ", userid='" + userid + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
