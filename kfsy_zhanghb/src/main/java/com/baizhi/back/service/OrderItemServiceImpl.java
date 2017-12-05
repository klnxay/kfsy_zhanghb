package com.baizhi.back.service;

import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.OrderItemDao;
import com.baizhi.common.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderItemService")
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;


    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItem> queryAll(String orderId) {

        List<OrderItem> orderItems = orderItemDao.selectAll(orderId);
        System.out.println(orderItems);
        return orderItems;
    }
}
