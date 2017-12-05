package com.baizhi.back.service;

import com.baizhi.common.entity.Type;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public interface TypeService {

    public void addOne(Type type);

    public void removeOne(String id,HttpServletRequest request);

    public void modifyOne(Type type);

    public Type queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
    public List<Type> queryAll();
}
