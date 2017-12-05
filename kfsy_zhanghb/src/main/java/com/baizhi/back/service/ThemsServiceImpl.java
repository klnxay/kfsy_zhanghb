package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.ThemsDao;
import com.baizhi.common.entity.Drug;
import com.baizhi.common.entity.Thems;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("themsService")
@Transactional
public class ThemsServiceImpl implements ThemsService {

    @Autowired
    private ThemsDao themsDao;

    @Override
    @FlushCache
    public void addOne(Thems thems) {
        thems.setId(UUID.randomUUID().toString());
        themsDao.insertOne(thems);
    }

    @Override
    @FlushCache
    public void removeOne(String id,HttpServletRequest request) {
        Thems thems = queryOneById(id);
        String image = thems.getImage();
        themsDao.deleteOne(id);
        String realPath = request.getSession().getServletContext().getRealPath("/back/thems/image");
        new File(realPath,image).delete();
    }

    @Override
    @FlushCache
    public void modifyOne(Thems thems) {
        themsDao.updateOne(thems);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Thems queryOneById(String id) {
        return themsDao.selectOneById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Thems> themss = themsDao.selectAll();
        PageInfo<Thems> pageInfo = new PageInfo<Thems>(themss);

        long total = pageInfo.getTotal();
        Map map = new HashMap();

        int t = (int)total;
        map.put("total",t);
        map.put("rows",themss);

        return map;
    }

    @Override
    @RedisCache
    public List<Thems> queryAll() {
        return themsDao.selectAll();
    }
}
