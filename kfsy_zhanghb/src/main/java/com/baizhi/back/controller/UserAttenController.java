package com.baizhi.back.controller;

import com.baizhi.back.service.UserAttenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/userAtten")
public class UserAttenController {

    @Autowired
    private UserAttenService userAttenService;

    @RequestMapping("/remove")
    public void remove(String id){

        userAttenService.remove(id);
    }

    @RequestMapping("/all")
    @ResponseBody
    public Map queryAll(Integer page,Integer rows){

        Map map = userAttenService.selectByPage(page,rows);
        System.out.println(map);
        return map;
    }
}
