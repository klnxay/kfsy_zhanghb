package com.baizhi.back.controller;

import com.baizhi.back.service.ServicesService;
import com.baizhi.common.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @RequestMapping("/all")
    @ResponseBody
    public Map queryAll(Integer page,Integer rows){
        Map map = servicesService.queryALL(page, rows);
        return map;
    }

    @RequestMapping("/add")
    public void add(Services services){
        System.out.println(services);
        servicesService.add(services);
    }

    @RequestMapping("/remove")
    public void remove(String id){
        servicesService.remove(id);
    }

    @RequestMapping("/sel")
    @ResponseBody
    public Services queryById(String id){
        Services services = servicesService.queryById(id);
        return services;
    }

    @RequestMapping("/modifi")
    public void modifi(){

    }
}
