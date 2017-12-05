package com.baizhi.common.entity;
//商品详情图
public class Pimage {
    private String id;
    private String image;
    private String proid;
    private String state;


    public Pimage() {
    }

    @Override
    public String toString() {
        return "Pimage{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", proid='" + proid + '\'' +
                ", state='" + state + '\'' +
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Pimage(String id, String image, String proid, String state) {

        this.id = id;
        this.image = image;
        this.proid = proid;
        this.state = state;
    }
}
