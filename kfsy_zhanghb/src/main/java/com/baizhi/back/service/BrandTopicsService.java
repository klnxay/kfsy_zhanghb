package com.baizhi.back.service;

import com.baizhi.common.entity.BrandTopics;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BrandTopicsService {

    public void addOne(BrandTopics brandTopics);

    public void removeOne(String id, HttpServletRequest request);

    public void modifyOne(BrandTopics brandTopics);

    public BrandTopics queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
    public List<BrandTopics> queryAll();
}
