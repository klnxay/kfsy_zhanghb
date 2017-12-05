package com.baizhi.common.entity;

public class Image {
    //药房实况图
    private String id;
    private String image;
    private String drugid;
    private String state;
    private String type;


    public Image() {
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", drugid='" + drugid + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Image(String id, String image, String drugid, String state, String type) {
        this.id = id;
        this.image = image;
        this.drugid = drugid;
        this.state = state;
        this.type = type;
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

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
