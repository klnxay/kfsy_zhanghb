package com.baizhi.common.entity;
//公司分类表
public class BrandTopics {
    private String id;
    private String  name;
    private String image;
    private String urlimage;

    public BrandTopics() {
    }

    public BrandTopics(String id, String name, String image, String urlimage) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.urlimage = urlimage;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    @Override
    public String toString() {
        return "BrandTopics{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", urlimage='" + urlimage + '\'' +
                '}';
    }
}
