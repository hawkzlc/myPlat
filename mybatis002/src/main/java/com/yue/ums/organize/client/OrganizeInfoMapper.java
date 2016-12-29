package com.yue.ums.organize.client;

import com.yue.ums.organize.model.OrganizeInfo;

public interface OrganizeInfoMapper {
    int deleteByPrimaryKey(Integer orgId);

    int insert(OrganizeInfo record);

    int insertSelective(OrganizeInfo record);

    OrganizeInfo selectByPrimaryKey(Integer orgId);

    int updateByPrimaryKeySelective(OrganizeInfo record);

    int updateByPrimaryKey(OrganizeInfo record);
}