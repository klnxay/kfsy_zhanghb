package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.common.dao.UserDao;
import com.baizhi.common.entity.User;
import com.baizhi.front.service.FUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class) //在测试类实例化时自动初始化springboot相关配置
@SpringBootTest(classes = {Application.class})//指定在初始化springboot应用时的入口类
public class Test1 {

    @Autowired
    private FUserService fUserService;
    @Autowired
    private UserDao userDao;

    @Test
    public void Test1(){


        fUserService.addUser(new User());

    }

    @Test
    public void Test2(){
        List<User> users = userDao.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
