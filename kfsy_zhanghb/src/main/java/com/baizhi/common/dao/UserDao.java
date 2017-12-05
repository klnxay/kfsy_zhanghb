package com.baizhi.common.dao;

import com.baizhi.common.entity.User;
import org.springframework.cache.annotation.Cacheable;

public interface UserDao extends BasicDAO<User>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public User selectByPhone(String phone);
}
