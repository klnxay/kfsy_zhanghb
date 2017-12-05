package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.ImageDao;
import com.baizhi.common.entity.Drug;
import com.baizhi.common.entity.Image;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
@Service
public class ImageServiceImpl implements  ImageService {

    @Autowired
    public ImageDao imageDao;

    @Override
    @FlushCache
    public void addOne(Image image) {
        image.setId(UUID.randomUUID().toString());
        imageDao.insertOne(image);
    }

    @Override
    @FlushCache
    public void removeOne(String id, HttpServletRequest request) {
        Image image = imageDao.selectOneById(id);
        System.out.println(image);
        String image1 = image.getImage();
        System.out.println(id);
        imageDao.deleteOne(id);
        String realPath = request.getSession().getServletContext().getRealPath("/back/image/image");
        new File(realPath,image1).delete();
    }

    @Override
    public void modifyOne(Image image) {

    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Image queryOneById(String id) {
        Image image = imageDao.selectOneById(id);
        return image;
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Image> images = imageDao.selectAll();

        PageInfo<Image> pageInfo = new PageInfo<Image>(images);

        long total = pageInfo.getTotal();
        Map map = new HashMap();

        int t = (int)total;
        map.put("total",t);
        map.put("rows",images);

        return map;
    }
}
