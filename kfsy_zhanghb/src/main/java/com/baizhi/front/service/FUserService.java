package com.baizhi.front.service;

import com.baizhi.common.entity.User;

public interface FUserService {

    public void addUser(User user);

    public void update(User user);

    public User queryOne(String phone);

    public void va(String phone);
}
