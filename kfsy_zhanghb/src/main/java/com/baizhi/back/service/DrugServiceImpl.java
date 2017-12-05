package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.DrugDao;
import com.baizhi.common.entity.Drug;
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

@Service("drugService")
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDao drugDao;

    @Override
    @FlushCache
    public void addOne(Drug drug) {
        drug.setId(UUID.randomUUID().toString());
        drugDao.insertOne(drug);
    }

    @Override
    @FlushCache
    public void removeOne(String id , HttpServletRequest request) {
        Drug drug = queryOneById(id);
        String logo = drug.getLogo();

        drugDao.deleteOne(id);

        String realPath = request.getSession().getServletContext().getRealPath("/back/drug/image");
        new File(realPath,logo).delete();
    }


    @Override
    @FlushCache
    public void modifyOne(Drug drug) {
        drugDao.updateOne(drug);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Drug queryOneById(String id) {
        return  drugDao.selectOneById(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Drug> drugs = drugDao.selectAll();

        PageInfo<Drug> pageInfo = new PageInfo<Drug>(drugs);

        long total = pageInfo.getTotal();
        Map map = new HashMap();

        int t = (int)total;
        map.put("total",t);
        map.put("rows",drugs);

        return map;
    }

    @Override
    @RedisCache
    public List<Drug> queryAll() {
        return drugDao.selectAll();
    }
}
