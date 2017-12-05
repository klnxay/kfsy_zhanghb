package com.baizhi.back.service;

import com.baizhi.common.entity.Image;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public interface ImageService {
    public void addOne(Image image);

    public void removeOne(String id, HttpServletRequest request);

    public void modifyOne(Image image);

    public Image queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
}
