package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.OrderDao;
import com.baizhi.common.entity.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @FlushCache
    public void addOne(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setDate(new Date());
        order.setNewdate(new Date());
        orderDao.insertOne(order);
    }

    @Override
    @FlushCache
    public void removeOne(String id) {
        orderDao.deleteOne(id);
    }

    @Override
    @FlushCache
    public void modifyOne(Order order) {
        orderDao.updateOne(order);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Order queryOneById(String id) {
        return orderDao.selectOneById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Order> orders = orderDao.selectAll();


        PageInfo<Order> pageInfo = new PageInfo<Order>(orders);

        long total = pageInfo.getTotal();
        Map map = new HashMap();

        int t = (int)total;
        map.put("total",t);
        map.put("rows",orders);

        return map;
    }
}
