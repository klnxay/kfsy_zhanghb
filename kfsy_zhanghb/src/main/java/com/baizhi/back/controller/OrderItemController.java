package com.baizhi.back.controller;

import com.baizhi.back.service.OrderItemService;
import com.baizhi.common.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @RequestMapping("/queryAll")
    public List<OrderItem> queryAll(String orderId){
        System.out.println(orderId);
        return orderItemService.queryAll(orderId);
    }

}
