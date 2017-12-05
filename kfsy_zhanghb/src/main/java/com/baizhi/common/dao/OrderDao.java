package com.baizhi.common.dao;


import com.baizhi.common.entity.Order;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 订单管理
 *
 * */
public interface OrderDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(Order order);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(Order order);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Order selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Order> selectAll();

}
