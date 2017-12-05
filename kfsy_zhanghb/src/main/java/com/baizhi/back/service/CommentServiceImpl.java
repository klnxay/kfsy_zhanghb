package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.CommentDao;
import com.baizhi.common.entity.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements  CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    @FlushCache
    public void remove(String id) {
        commentDao.delete(id);
    }

    @Override
    @RedisCache
    public Map queryAll(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Comment> comments = commentDao.selectAll();
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",comments);
        return map;
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public Comment queryById(String id) {
        return commentDao.selectById(id);
    }

    @Override
    @RedisCache
    public Map queryByService(String seid,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<Comment> comments = commentDao.selectByServices(seid);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(comments);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",comments);
        return map;
    }
}
