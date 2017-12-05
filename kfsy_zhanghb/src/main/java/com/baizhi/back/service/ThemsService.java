package com.baizhi.back.service;

import com.baizhi.common.entity.Thems;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ThemsService {

    public void addOne(Thems thems);

    public void removeOne(String id,HttpServletRequest request);

    public void modifyOne(Thems thems);

    public Thems queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
    public List<Thems> queryAll();
}
