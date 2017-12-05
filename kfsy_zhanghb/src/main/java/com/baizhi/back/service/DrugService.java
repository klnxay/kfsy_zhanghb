package com.baizhi.back.service;


import com.baizhi.common.entity.Drug;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DrugService {

    public void addOne(Drug drug);

    public void removeOne(String id , HttpServletRequest request);

    public void modifyOne(Drug drug);

    public Drug queryOneById(String id);

    public Map queryAll(Integer page, Integer rows);
    public List<Drug> queryAll();
}
