package com.baizhi.common.dao;

import com.baizhi.common.entity.Services;
import org.springframework.cache.annotation.Cacheable;

public interface ServicesDao extends BasicDAO<Services> {

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Services selectByName(String name);
}
