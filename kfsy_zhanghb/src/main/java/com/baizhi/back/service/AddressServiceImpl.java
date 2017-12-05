package com.baizhi.back.service;

import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.AddressDao;
import com.baizhi.common.entity.Address;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressDao addressDao;
    @Override
    @RedisCache
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Address> addresss = addressDao.selectAll();
        PageInfo<Address> pageInfo = new PageInfo<Address>(addresss);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",addresss);
        return map;
    }
}
