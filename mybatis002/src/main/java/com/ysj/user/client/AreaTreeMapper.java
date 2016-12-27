package com.ysj.user.client;

import com.ysj.user.model.AreaTree;

public interface AreaTreeMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(AreaTree record);

    int insertSelective(AreaTree record);

    AreaTree selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(AreaTree record);

    int updateByPrimaryKey(AreaTree record);
}