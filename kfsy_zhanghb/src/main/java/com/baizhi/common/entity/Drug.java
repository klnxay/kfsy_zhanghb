package com.baizhi.common.entity;

import java.util.List;

public class Drug {
    private String id;
    private String name;
    private String logo;//图标
    private String address;
    private String content;//内容
    private List<Product> products;

    public Drug() {
    }

    public Drug(String id, String name, String logo, String address, String content, List<Product> products) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.address = address;
        this.content = content;
        this.products = products;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", products=" + products +
                '}';
    }
}
