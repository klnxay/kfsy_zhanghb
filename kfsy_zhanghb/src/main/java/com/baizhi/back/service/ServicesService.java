package com.baizhi.back.service;

import com.baizhi.common.entity.Services;

import java.util.List;
import java.util.Map;

public interface ServicesService   {

    public void add(Services services);

    public void modifi(Services services);

    public void modifis(List<Services> servicess);

    public void remove(String id);

    public Map queryALL(Integer page, Integer rows);

    public Services queryById(String id);

    public Services queryByName(String name);

    public List<Services> queryAlls();
}
