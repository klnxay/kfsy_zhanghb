package com.baizhi.common.dao;

import com.baizhi.common.entity.Image;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ImageDao {

    @CacheEvict(value = "districtDataCache")
    public void insertOne(Image image);

    @CacheEvict(value = "districtDataCache")
    public void deleteOne(String id);

    @CacheEvict(value = "districtDataCache")
    public void updateOne(Image image);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Image selectOneById(String id);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Image> selectAll();

}
