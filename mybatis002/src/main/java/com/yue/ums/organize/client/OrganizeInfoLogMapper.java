package com.yue.ums.organize.client;

import com.yue.ums.organize.model.OrganizeInfoLog;

public interface OrganizeInfoLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(OrganizeInfoLog record);

    int insertSelective(OrganizeInfoLog record);

    OrganizeInfoLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(OrganizeInfoLog record);

    int updateByPrimaryKey(OrganizeInfoLog record);
}