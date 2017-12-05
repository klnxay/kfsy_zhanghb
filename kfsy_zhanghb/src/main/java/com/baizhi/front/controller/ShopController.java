package com.baizhi.front.controller;

import com.baizhi.common.entity.OrderItem;
import com.baizhi.common.entity.Result;
import com.baizhi.front.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/add")
    public Result addOrderitem(String userid,String proid){
        Result result = new Result();
        try {
            shopService.addProductCart(userid,proid);
            result = new Result(true,"成功");
        } catch (Exception e) {
            result = new Result(true,"失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(String userid,String proid){
        Result result = new Result();
        try {
            shopService.deleteProductCare(userid,proid);
            result = new Result(true,"成功");
        } catch (Exception e) {
            result = new Result(true,"失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/queryAll")
    public Map<String,OrderItem> queryAll(String userid){
        Map<String, OrderItem> map = shopService.queryAll(userid);
        return map;
    }

    @RequestMapping("/addnum")
    public Result addnum(String userid,String proid,Integer num){
        Result result = new Result();
        try {
            shopService.addnum(userid,proid,num);
            result = new Result(true,"成功");
        } catch (Exception e) {
            result = new Result(true,"失败");
            e.printStackTrace();
        }
        return result;
    }
}
