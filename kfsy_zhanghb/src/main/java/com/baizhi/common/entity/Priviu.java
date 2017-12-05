package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Priviu {

    private String id;
    private Integer num;
    private String userid;
    private String state;
    private Double price;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date odate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date ndate;
    private String privi_id;

    public String getPrivi_id() {
        return privi_id;
    }

    public void setPrivi_id(String privi_id) {
        this.privi_id = privi_id;
    }

    public Priviu(String id, Integer num, String userid, String state, Double price, String name, Date odate, Date ndate, String privi_id) {

        this.id = id;
        this.num = num;
        this.userid = userid;
        this.state = state;
        this.price = price;
        this.name = name;
        this.odate = odate;
        this.ndate = ndate;
        this.privi_id = privi_id;
    }

    @Override
    public String toString() {
        return "Priviu{" +
                "id='" + id + '\'' +
                ", num=" + num +
                ", userid='" + userid + '\'' +
                ", state='" + state + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", odate=" + odate +
                ", ndate=" + ndate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Date getNdate() {
        return ndate;
    }

    public void setNdate(Date ndate) {
        this.ndate = ndate;
    }

    public Priviu(String id, Integer num, String userid, String state, Double price, String name, Date odate, Date ndate) {

        this.id = id;
        this.num = num;
        this.userid = userid;
        this.state = state;
        this.price = price;
        this.name = name;
        this.odate = odate;
        this.ndate = ndate;
    }

    public Priviu() {
        super();
    }
}
