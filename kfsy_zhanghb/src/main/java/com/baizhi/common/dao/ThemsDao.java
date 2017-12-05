package com.baizhi.common.dao;

import com.baizhi.common.entity.Thems;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ThemsDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(Thems thems);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(Thems thems);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Thems selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Thems> selectAll();

}
