package com.baizhi.back.service;

import com.baizhi.common.entity.Priviu;

import java.util.Map;

public interface PriviuService {

    public void remove(String id);

    public void modifi(Priviu priviu);

    public Map queryAll(Integer page, Integer rows);

    public Priviu queryById(String id);
}
