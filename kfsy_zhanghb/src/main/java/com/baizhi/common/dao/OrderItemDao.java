package com.baizhi.common.dao;

import com.baizhi.common.entity.OrderItem;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 订单管理
 *
 * */
public interface OrderItemDao extends BasicDAO<OrderItem>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<OrderItem> selectAll(String orderId);

}
