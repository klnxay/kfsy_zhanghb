package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.CommentDao;
import com.baizhi.common.dao.ServicesDao;
import com.baizhi.common.entity.Services;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("servicesService")
@Transactional
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesDao servicesDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    @FlushCache
    public void add(Services services) {
        services.setId(UUID.randomUUID().toString());
        services.setCount(0);
        servicesDao.insert(services);
    }

    @Override
    @FlushCache
    public void modifi(Services services) {
        servicesDao.update(services);
    }

    @Override
    @FlushCache
    public void modifis(List<Services> servicess) {

        for (Services services : servicess) {
            servicesDao.update(services);
        }
    }

    @Override
    @FlushCache
    public void remove(String id) {
        servicesDao.delete(id);
    }

    @Override
    @RedisCache
    public Map queryALL(Integer page, Integer rows) {
        List<Services> servicesss = servicesDao.selectAll();
        List<Services> Servicess = new ArrayList<Services>();
        PageHelper.startPage(page,rows);

        for (Services services : servicesss) {
            Integer integer = commentDao.selectCount(services.getId());
            services.setCount(integer);
            Servicess.add(services);
        }
        modifis(Servicess);
        PageInfo<Services> pageInfo = new PageInfo<Services>(Servicess);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",Servicess);
        return map;
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Services queryById(String id) {
        return servicesDao.selectById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Services queryByName(String name) {
        return servicesDao.selectByName(name);
    }

    @Override
    @RedisCache
    public List<Services> queryAlls() {
        return servicesDao.selectAll();
    }


}
