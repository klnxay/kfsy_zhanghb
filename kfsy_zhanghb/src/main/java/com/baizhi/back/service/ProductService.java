package com.baizhi.back.service;

import com.baizhi.common.entity.Product;

import java.util.List;

public interface ProductService {

    public void insert(Product product);

    public void delete(String id);

    public void update(Product product);

    public Product queryOne(String id);

    public List<Product> queryAll();
}
