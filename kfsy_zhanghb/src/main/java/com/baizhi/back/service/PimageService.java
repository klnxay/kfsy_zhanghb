package com.baizhi.back.service;

import com.baizhi.common.entity.Pimage;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface PimageService{
    public void addOne(Pimage pimage);

    public void removeOne(String id, HttpServletRequest request);

    public void modifyOne(Pimage pimage);

    public Pimage queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);

}
