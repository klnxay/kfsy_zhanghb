package com.baizhi.common.entity;

public class Pic {
    //商品轮播图
    private String id;
    private String image;
    private String proid;


    public Pic() {
    }

    public Pic(String id, String image, String proid) {
        this.id = id;
        this.image = image;
        this.proid = proid;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", proid='" + proid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }
}
