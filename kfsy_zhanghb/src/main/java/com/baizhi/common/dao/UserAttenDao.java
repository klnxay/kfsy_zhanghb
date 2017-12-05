package com.baizhi.common.dao;

import com.baizhi.common.entity.UserAtten;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface UserAttenDao extends BasicDAO<UserAtten>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<UserAtten> selectByUserid(String id);
}
