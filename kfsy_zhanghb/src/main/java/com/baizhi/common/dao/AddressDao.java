package com.baizhi.common.dao;

import com.baizhi.common.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

public interface AddressDao extends BasicDAO<Address>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Address queryByUserid(@Param("userid")String userid);
}
