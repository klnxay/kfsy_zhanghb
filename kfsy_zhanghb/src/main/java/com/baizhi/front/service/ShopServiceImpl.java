package com.baizhi.front.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.common.dao.OrderItemDao;
import com.baizhi.common.dao.ProductDao;
import com.baizhi.common.entity.OrderItem;
import com.baizhi.common.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private Jedis jedis;
    @Override
    public void addProductCart(String userid,String proid){
        Product product = productDao.selectById(proid);
        Map<String, String> map1 = new HashMap<String, String>();
        OrderItem orderItem = new OrderItem(UUID.randomUUID().toString(), null, proid, 1, product.getNewprice());
        String s = JSONObject.toJSONString(orderItem);
        if(!jedis.exists(userid)){
            map1.put(proid,s);
            jedis.hmset(userid, map1);
        }else{
            String s1 = map1.get(proid);
            if(s==null){
                map1.put(proid,s);
                jedis.hmset(userid, map1);
            }else{
                Map<String, String> map = jedis.hgetAll(userid);
                String s2 = map.get(proid);
                OrderItem orderItem1 = JSONObject.parseObject(s2,OrderItem.class);
                orderItem1.setNum(orderItem1.getNum()+1);
                orderItem1.setPrice(product.getNewprice() * orderItem1.getNum());
                String s3 = JSONObject.toJSONString(orderItem1);
                map.put(proid,s3);
                jedis.hmset(userid,map);
            }
        }

    }

    public Map<String,OrderItem> queryAll(String userid){
        Map<String,OrderItem> map = new HashMap<String, OrderItem>();
        Map<String, String> map1 = jedis.hgetAll(userid);
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String value = entry.getValue();
            OrderItem orderItem1 = JSONObject.parseObject(value,OrderItem.class);
            map.put(entry.getKey(),orderItem1);
        }
        return map;
    }

    public void deleteProductCare(String userid,String proid){
        Map<String, String> map = jedis.hgetAll(userid);
        System.out.println(map);
        map.remove(proid);
        System.out.println(map);
        if(map!=null){
            jedis.hdel(userid,proid);
        }else{
            jedis.del(userid);
        }
    }

    public void addnum(String userid,String proid,Integer num){
        Map<String, String> map = jedis.hgetAll(userid);
        String s = map.get(proid);
        OrderItem orderItem = JSONObject.parseObject(s,OrderItem.class);
        orderItem.setNum(num);
        String s1 = JSONObject.toJSONString(orderItem);
        map.put(proid,s1);
        jedis.hmset(userid,map);
    }
}
