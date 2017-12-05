package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.UserAttenDao;
import com.baizhi.common.entity.UserAtten;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userAttenService")
@Transactional
public class UserAttenServiceImpl implements UserAttenService {

    @Autowired
    private UserAttenDao userAttenDao;

    @Override
    @FlushCache
    public void remove(String id) {
        userAttenDao.delete(id);
    }

    @Override
    @RedisCache
    public Map selectByPage(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<UserAtten> userAttens = userAttenDao.selectAll();
        PageInfo<UserAtten> pageInfo = new PageInfo<UserAtten>(userAttens);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",userAttens);
        return map;
    }
}
