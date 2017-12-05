package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.BrandTopicsDao;
import com.baizhi.common.entity.BrandTopics;
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

@Service("brandTopicsService")
public class BrandTopicsServiceImpl implements BrandTopicsService {

    @Autowired
    private BrandTopicsDao brandTopicsDao;

    @Override
    @FlushCache
    public void addOne(BrandTopics brandTopics) {
        brandTopics.setId(UUID.randomUUID().toString());
        brandTopicsDao.insertOne(brandTopics);
    }

    @Override
    @FlushCache
    public void removeOne(String id, HttpServletRequest request) {
        BrandTopics brandTopics = queryOneById(id);
        String image = brandTopics.getImage();
        String urlimage = brandTopics.getUrlimage();

        brandTopicsDao.deleteOne(id);

        String realPath = request.getSession().getServletContext().getRealPath("/back/brand/image");
        new File(realPath,image).delete();
        new File(realPath,urlimage).delete();
    }



    @Override
    @FlushCache
    public void modifyOne(BrandTopics brandTopics) {
        brandTopicsDao.updateOne(brandTopics);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public BrandTopics queryOneById(String id) {
        return  brandTopicsDao.selectOneById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<BrandTopics> brandTopicss = brandTopicsDao.selectAll();

        PageInfo<BrandTopics> pageInfo = new PageInfo<BrandTopics>(brandTopicss);

        long total = pageInfo.getTotal();
        Map map = new HashMap();

        int t = (int)total;
        map.put("total",t);
        map.put("rows",brandTopicss);

        return map;
    }

    @Override
    @RedisCache
    public List<BrandTopics> queryAll() {
        return brandTopicsDao.selectAll();
    }


}
