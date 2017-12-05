package com.baizhi.common.entity;

public class OrderItem {
    private String id;
    private String orderid;
    private String proid;
    private Integer num;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(String id, String orderid, String proid, Integer num, Double price) {
        this.id = id;
        this.orderid = orderid;
        this.proid = proid;
        this.num = num;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", orderid='" + orderid + '\'' +
                ", proid='" + proid + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
