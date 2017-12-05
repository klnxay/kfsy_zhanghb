package com.baizhi.common.dao;

import com.baizhi.common.entity.Comment;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CommentDao extends BasicDAO<Comment>{

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public List<Comment> selectByServices(String seid);

    @Cacheable(value = "districtDataCache",key = "#root.target + #root.methodName +#p0" )
    public Integer selectCount(String seid);
}
