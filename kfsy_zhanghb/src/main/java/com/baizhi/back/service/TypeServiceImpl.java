package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.TypeDao;
import com.baizhi.common.entity.Type;
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

@Service("typeService")
@Transactional
public class TypeServiceImpl implements TypeService {


    @Autowired
    private TypeDao typeDao;

    @Override
    @FlushCache
    public void addOne(Type type) {
        type.setId(UUID.randomUUID().toString());
        typeDao.insertOne(type);
    }

    @Override
    @FlushCache
    public void removeOne(String id,HttpServletRequest request) {
        Type type = queryOneById(id);
        String image = type.getImage();
        typeDao.deleteOne(id);
        String realPath = request.getSession().getServletContext().getRealPath("/back/type/image");
        new File(realPath,image).delete();
    }

    @Override
    @FlushCache
    public void modifyOne(Type type) {
        typeDao.updateOne(type);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Type queryOneById(String id) {
        return typeDao.selectOneById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Type> types = typeDao.selectAll();
        PageInfo<Type> pageInfo = new PageInfo<Type>(types);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",types);

        return map;
    }

    @Override
    @RedisCache
    public List<Type> queryAll() {
        return typeDao.selectAll();
    }
}
