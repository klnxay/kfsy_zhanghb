package com.baizhi.back.controller;

import com.baizhi.back.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Map queryAll(Integer page,Integer rows){
        Map map = addressService.queryAll(page, rows);
        return map;
    }
}
