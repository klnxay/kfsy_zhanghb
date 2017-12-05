package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//优惠券
public class Privi {
    private String id;
    private String name;
    private Double price;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   odate;//生效日期
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   ndate;//失效日期
    public Privi() {
    }

    public Privi(String id, String name, Double price, Date odate, Date ndate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.odate = odate;
        this.ndate = ndate;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Privi{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", odate=" + odate +
                ", ndate=" + ndate +
                '}';
    }
}
