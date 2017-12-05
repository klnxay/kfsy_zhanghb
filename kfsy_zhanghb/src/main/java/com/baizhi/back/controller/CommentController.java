package com.baizhi.back.controller;

import com.baizhi.back.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/all")
    @ResponseBody
    public Map queryAll(Integer page,Integer rows){
        Map map = commentService.queryAll(page, rows);
        return map;
    }

    @RequestMapping("/remove")
    public void remove(String id){
        commentService.remove(id);
    }

}
