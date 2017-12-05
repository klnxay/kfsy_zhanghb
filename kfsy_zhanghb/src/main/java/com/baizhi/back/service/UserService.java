package com.baizhi.back.service;

import com.baizhi.common.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public void modifi(User user);

    public void remove(String id);

    public User queryUser(String id);

    public Map selectByPage(Integer page , Integer rows);

    public List<User> queryAll();
}
