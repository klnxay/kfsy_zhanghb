package com.baizhi.common.dao;


import com.baizhi.common.entity.Drug;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
/**
 * 药房管理
 *
 * */
public interface DrugDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(Drug drug);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(Drug drug);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Drug selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Drug> selectAll();

}
