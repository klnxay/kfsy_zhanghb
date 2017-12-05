package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private String id;
    private String addressid;
    private String content;
    private String userid;
    private String buy;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   date;//下单时间
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   newdate;//完成时间
    private String state;

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order(String id, String addressid, String content, String userid, String buy, Date date, Date newdate, String state) {

        this.id = id;
        this.addressid = addressid;
        this.content = content;
        this.userid = userid;
        this.buy = buy;
        this.date = date;
        this.newdate = newdate;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", addressid='" + addressid + '\'' +
                ", content='" + content + '\'' +
                ", userid='" + userid + '\'' +
                ", buy='" + buy + '\'' +
                ", date=" + date +
                ", newdate=" + newdate +
                ", state='" + state + '\'' +
                '}';
    }
}
