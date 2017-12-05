package com.baizhi.common.dao;

import com.baizhi.common.entity.Type;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface TypeDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(Type type);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(Type type);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Type selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Type> selectAll();

}
