package com.yue.ums.client;

import com.yue.ums.model.SystemDict;

public interface SystemDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemDict record);

    int insertSelective(SystemDict record);

    SystemDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemDict record);

    int updateByPrimaryKey(SystemDict record);
}