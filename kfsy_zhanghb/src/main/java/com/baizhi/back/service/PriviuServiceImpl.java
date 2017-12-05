package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.PriviuDao;
import com.baizhi.common.entity.Priviu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("priviuService")
@Transactional
public class PriviuServiceImpl implements PriviuService {

    @Autowired
    private PriviuDao priviuDao;

    @Override
    @FlushCache
    public void remove(String id) {
        priviuDao.delete(id);
    }

    @Override
    @FlushCache
    public void modifi(Priviu priviu) {
        priviuDao.update(priviu);
    }

    @Override
    @RedisCache
    public Map queryAll(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);
        List<Priviu> privius = priviuDao.selectAll();
        PageInfo<Priviu> pageInfo = new PageInfo<Priviu>(privius);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",privius);
        return map;
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Priviu queryById(String id) {
        return priviuDao.selectById(id);
    }
}
