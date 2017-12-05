package com.baizhi.common.entity;

public class UserAtten {
    private String id;
    private String userid;
    private String proid;

    public UserAtten() {
    }

    public UserAtten(String id, String userid, String proid) {
        this.id = id;
        this.userid = userid;
        this.proid = proid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    @Override
    public String toString() {
        return "UserAtten{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", proid='" + proid + '\'' +
                '}';
    }
}
