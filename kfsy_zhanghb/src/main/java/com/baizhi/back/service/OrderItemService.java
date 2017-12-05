package com.baizhi.back.service;

import com.baizhi.common.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    public List<OrderItem> queryAll(String orderId);
}
