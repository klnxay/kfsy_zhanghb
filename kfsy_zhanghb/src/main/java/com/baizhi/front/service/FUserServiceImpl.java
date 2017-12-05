package com.baizhi.front.service;

import com.baizhi.common.dao.UserDao;
import com.baizhi.common.entity.User;
import com.baizhi.common.util.Ali;
import com.baizhi.common.util.SaltUtils;
import com.baizhi.common.util.VaUtils;
import com.baizhi.common.util.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class FUserServiceImpl implements FUserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setSalt(SaltUtils.getSalts(6));
        String s = VaUtils.generateVerifyCode(6);
        user.setUsername(s);
        user.setState("激活");
        /*user.setPhone("18511539551");
        user.setState("激活");
        user.setUsername("张");*/
        user.setDate(new Date());
        if(user.getPassword()!=null) {
            String password = DigestUtils.md5DigestAsHex((user.getPassword() + user.getSalt()).getBytes());
            user.setPassword(password);
        }
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    public User queryOne(String phone) {
        User user = userDao.selectByPhone(phone);
        return user;
    }

    @Override
    public void va(String phone) {
        try {
            Valid.va(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
