package com.baizhi.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private String standerd;
    private String comment;
    private Double oldprice;//原价
    private Double newprice;//现价
    private String description;
    private Double discount;//打折
    private String typeid;
    private String bratoid;//公司id
    private String themsid;
    private String drugid;
    private Double offer;//特价
    private Integer sum;// 库存
    private Integer count;//销量
    private String image;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date olddate;//上架时间
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date newdate;//下架时间
    private String state;
    private Type type;//分类
    private BrandTopics brandTopics;//公司
    private Thems thems;//主题
    private Drug drug;//药房

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", standerd='" + standerd + '\'' +
                ", comment='" + comment + '\'' +
                ", oldprice=" + oldprice +
                ", newprice=" + newprice +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", typeid='" + typeid + '\'' +
                ", bratoid='" + bratoid + '\'' +
                ", themsid='" + themsid + '\'' +
                ", drugid='" + drugid + '\'' +
                ", offer=" + offer +
                ", sum=" + sum +
                ", count=" + count +
                ", image='" + image + '\'' +
                ", olddate=" + olddate +
                ", newdate=" + newdate +
                ", state='" + state + '\'' +
                ", type=" + type +
                ", brandTopics=" + brandTopics +
                ", thems=" + thems +
                ", drug=" + drug +
                '}';
    }

    public Product(String id, String name, String standerd, String comment, Double oldprice, Double newprice, String description, Double discount, String typeid, String bratoid, String themsid, String drugid, Double offer, Integer sum, Integer count, String image, Date olddate, Date newdate, String state, Type type, BrandTopics brandTopics, Thems thems, Drug drug) {
        this.id = id;
        this.name = name;
        this.standerd = standerd;
        this.comment = comment;
        this.oldprice = oldprice;
        this.newprice = newprice;
        this.description = description;
        this.discount = discount;
        this.typeid = typeid;
        this.bratoid = bratoid;
        this.themsid = themsid;
        this.drugid = drugid;
        this.offer = offer;
        this.sum = sum;
        this.count = count;
        this.image = image;
        this.olddate = olddate;
        this.newdate = newdate;
        this.state = state;
        this.type = type;
        this.brandTopics = brandTopics;
        this.thems = thems;
        this.drug = drug;
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

    public String getStanderd() {
        return standerd;
    }

    public void setStanderd(String standerd) {
        this.standerd = standerd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getBratoid() {
        return bratoid;
    }

    public void setBratoid(String bratoid) {
        this.bratoid = bratoid;
    }

    public String getThemsid() {
        return themsid;
    }

    public void setThemsid(String themsid) {
        this.themsid = themsid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getOlddate() {
        return olddate;
    }

    public void setOlddate(Date olddate) {
        this.olddate = olddate;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public BrandTopics getBrandTopics() {
        return brandTopics;
    }

    public void setBrandTopics(BrandTopics brandTopics) {
        this.brandTopics = brandTopics;
    }

    public Thems getThems() {
        return thems;
    }

    public void setThems(Thems thems) {
        this.thems = thems;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
