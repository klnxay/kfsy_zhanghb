package com.baizhi.back.service;

import com.baizhi.common.entity.Comment;

import java.util.Map;

public interface CommentService {

    public void remove(String id);

    public Map queryAll(Integer page, Integer rows);

    public Comment queryById(String id);

    public Map queryByService(String seid, Integer page, Integer rows);
}
