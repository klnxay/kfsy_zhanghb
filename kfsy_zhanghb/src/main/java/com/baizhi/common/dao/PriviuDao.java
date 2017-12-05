package com.baizhi.common.dao;

import com.baizhi.common.entity.Priviu;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface PriviuDao extends BasicDAO<Priviu>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Priviu> selectByUserid(String userid);
}
