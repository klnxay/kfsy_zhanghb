package com.baizhi.back.service;

import com.baizhi.common.annotation.FlushCache;
import com.baizhi.common.annotation.RedisCache;
import com.baizhi.common.dao.UserDao;
import com.baizhi.common.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    @FlushCache
    public void modifi(User user) {
        userDao.update(user);
    }

    @Override
    @FlushCache
    public void remove(String id) {
        userDao.delete(id);
    }

    @Override
    @RedisCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUser(String id) {
        return userDao.selectById(id);
    }

    @Override
    @RedisCache
    public Map selectByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<User> users = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        long total = pageInfo.getTotal();
        Map map = new HashMap();
        int t = (int)total;
        map.put("total",t);
        map.put("rows",users);
        return map;

    }

    @Override
    @RedisCache
    public List<User> queryAll() {
        return userDao.selectAll();
    }
}
