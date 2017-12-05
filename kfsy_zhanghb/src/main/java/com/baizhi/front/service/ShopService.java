package com.baizhi.front.service;

import com.baizhi.common.entity.OrderItem;
import com.baizhi.common.entity.Product;

import java.util.Map;

public interface ShopService {

    public void addProductCart(String proid,String userid);

    public void deleteProductCare(String userid,String proid);

    public Map<String,OrderItem> queryAll(String userid);

    public void addnum(String userid,String proid,Integer num);
}
