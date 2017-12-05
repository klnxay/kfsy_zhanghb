package com.baizhi.back.controller;

import com.baizhi.back.service.PriviuService;
import com.baizhi.common.entity.Priviu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/priviu")
public class PriviuController {

    @Autowired
    private PriviuService priviuService;

    @RequestMapping("/all")
    @ResponseBody
    public Map queryAll(Integer page,Integer rows){
        Map map = priviuService.queryAll(page, rows);
        return map;
    }

    @RequestMapping("/remove")
    public void remove(String id){
        priviuService.remove(id);
    }

    @RequestMapping("/modifi")
    public void modifi(Priviu priviu){

        priviuService.modifi(priviu);
    }

    @RequestMapping("/byid")
    @ResponseBody
    public Priviu queryById(String id){
        Priviu priviu = priviuService.queryById(id);
        System.out.println(priviu);
        return priviu;
    }
}
