package com.baizhi.common.dao;

import com.baizhi.common.entity.BrandTopics;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface BrandTopicsDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(BrandTopics brandTopics);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(BrandTopics brandTopics);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public BrandTopics selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<BrandTopics> selectAll();

}
