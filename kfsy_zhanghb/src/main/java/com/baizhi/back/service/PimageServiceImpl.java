package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.PimageDao;
import com.baizhi.common.entity.Pimage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class PimageServiceImpl implements PimageService {

    @Resource
    private PimageDao pimageDao;

    @Override
    @FlushCache
    public void addOne(Pimage pimage) {
        pimage.setId(UUID.randomUUID().toString());
        pimage.setState("未激活");
        pimageDao.insert(pimage);

    }

    @Override
    @FlushCache
    public void modifyOne(Pimage pimage) {
        pimageDao.update(pimage);
    }

    @Override
    @FlushCache
    public void removeOne(String id, HttpServletRequest request) {
        Pimage pimage = queryOneById(id);
        String image = pimage.getImage();
        pimageDao.delete(id);
        String realPath = request.getSession().getServletContext().getRealPath("/back/pimage/image");
    }

    @Override
    @RedisCache
    public Pimage queryOneById(String id) {
        Pimage pimage = pimageDao.selectById(id);
        return pimage;
    }

    @Override
    @RedisCache
    public Map queryAll(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<Pimage> pimages = pimageDao.selectAll();
        PageInfo<Pimage> pageInfo = new PageInfo<Pimage>(pimages);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",pimages);

        return map;
    }
}
