package com.yue.ums.client;

import com.yue.ums.model.AreaTree;

public interface AreaTreeMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(AreaTree record);

    int insertSelective(AreaTree record);

    AreaTree selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(AreaTree record);

    int updateByPrimaryKey(AreaTree record);
}