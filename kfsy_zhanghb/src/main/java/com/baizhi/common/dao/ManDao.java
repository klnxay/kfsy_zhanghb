package com.baizhi.common.dao;

import com.baizhi.common.entity.Man;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

public interface ManDao {

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Man queryByName(@Param("username") String username);
}
