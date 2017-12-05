package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.ProductDao;
import com.baizhi.common.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    @Override
    @FlushCache
    public void insert(Product product) {

        if(product.getOlddate().getTime()<product.getNewdate().getTime()){
            product.setState("已激活");
        }else{
            product.setState("已过期");
        }
        product.setId(UUID.randomUUID().toString());
        productDao.insert(product);
    }

    @Override
    @FlushCache
    public void delete(String id) {
        productDao.delete(id);
    }

    @Override
    @FlushCache
    public void update(Product product) {
        if(product.getOlddate().getTime()<product.getNewdate().getTime()){
            product.setState("已激活");
        }else{
            product.setState("已过期");
        }
        productDao.update(product);
    }

    @Override
    @RedisCache
    public Product queryOne(String id) {
        return productDao.selectById(id);
    }

    @Override
    @RedisCache
    public List<Product> queryAll() {
        return productDao.selectAll();
    }
}
