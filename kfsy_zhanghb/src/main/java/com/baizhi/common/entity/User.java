package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class User {
    private String id;
    private String phone;
    private String username;
    private String password;
    private String salt;
    private String state;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  date;
    private List<Address> addrs;
    private List<Comment> comments;//商品评论
    private List<Order> orders;
    private List<UserAtten> userAttens;//关注
    private  List<Privi> privis;

    public User() {
    }

    public User(String id, String phone, String username, String password, String salt, String state, Date date, List<Address> addrs, List<Comment> comments, List<Order> orders, List<UserAtten> userAttens, List<Privi> privis) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.date = date;
        this.addrs = addrs;
        this.comments = comments;
        this.orders = orders;
        this.userAttens = userAttens;
        this.privis = privis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Address> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<Address> addrs) {
        this.addrs = addrs;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<UserAtten> getUserAttens() {
        return userAttens;
    }

    public void setUserAttens(List<UserAtten> userAttens) {
        this.userAttens = userAttens;
    }

    public List<Privi> getPrivis() {
        return privis;
    }

    public void setPrivis(List<Privi> privis) {
        this.privis = privis;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state='" + state + '\'' +
                ", date=" + date +
                ", addrs=" + addrs +
                ", comments=" + comments +
                ", orders=" + orders +
                ", userAttens=" + userAttens +
                ", privis=" + privis +
                '}';
    }
}
