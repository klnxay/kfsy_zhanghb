package com.baizhi.common.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BasicDAO<T> {

    @CacheEvict(value="districtDataCache")
    public void insert(T t);

    @CacheEvict(value="districtDataCache")
    public void delete(@Param("id") String id);

    @CacheEvict(value="districtDataCache")
    public void update(T t);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public T selectById(@Param("id") String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<T> selectAll();
}
