package com.baizhi.back.service;


import com.baizhi.common.entity.Order;

import java.util.Map;

public interface OrderService {

    public void addOne(Order order);

    public void removeOne(String id);

    public void modifyOne(Order order);

    public Order queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
}
