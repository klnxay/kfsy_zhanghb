package com.baizhi.back.service;

import java.util.Map;

public interface UserAttenService {

    public void remove(String id);

    public Map selectByPage(Integer page, Integer rows);
}
