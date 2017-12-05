package com.baizhi.back.controller;

import com.baizhi.back.service.OrderService;
import com.baizhi.common.entity.Order;
import com.baizhi.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    public Result addPrivi(Order order){

        Result result = new Result();

        orderService.addOne(order);
        result.setMassage("添加成功");
        result.setSuccess(true);

        return result;
    }

    @RequestMapping("/removeOne")
    public Result removeOne(String id){
        Result result = new Result();
        try {
            orderService.removeOne(id);
            result.setMassage("删除成功");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMassage("删除失败");
            result.setSuccess(false);
        }
        return  result;
    }

    @RequestMapping("/modifyOne")
    public Result modifyOne(Order order){
        Result result = new Result();

        try {
            orderService.modifyOne(order);
            result.setMassage("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMassage("修改失败");
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/queryOneById")
    public Order queryOneById(String id){
        return orderService.queryOneById(id);
    }

    @RequestMapping("/queryAll")
    public Map queryAll(Integer page,Integer rows){
        return orderService.queryAll(page,rows);
    }

}
