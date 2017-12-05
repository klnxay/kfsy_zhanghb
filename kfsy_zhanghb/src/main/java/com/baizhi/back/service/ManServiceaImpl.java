package com.baizhi.back.service;

import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.ManDao;
import com.baizhi.common.entity.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManServiceaImpl implements ManService{

    @Autowired
    private ManDao manDao;
    @Override
    @RedisCache
    public Man queryOne(String username) {
        Man man = manDao.queryByName(username);
        return man;
    }
}
