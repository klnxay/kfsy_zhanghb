package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private String id;
    private String content;//内容
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer grade;//等级
    private String names;
    private String name;
    private String  serviceid;
    private String orderid;


    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", grade=" + grade +
                ", names='" + names + '\'' +
                ", name='" + name + '\'' +
                ", serviceid='" + serviceid + '\'' +
                ", orderid='" + orderid + '\'' +
                '}';
    }

    public Comment(String id, String content, Date date, Integer grade, String names, String name, String serviceid, String orderid) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.grade = grade;
        this.names = names;
        this.name = name;
        this.serviceid = serviceid;
        this.orderid = orderid;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
