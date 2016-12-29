package com.yue.ums.organize.client;

import com.yue.ums.organize.model.OrgRoleRlt;

public interface OrgRoleRltMapper {
    int deleteByPrimaryKey(Integer rltId);

    int insert(OrgRoleRlt record);

    int insertSelective(OrgRoleRlt record);

    OrgRoleRlt selectByPrimaryKey(Integer rltId);

    int updateByPrimaryKeySelective(OrgRoleRlt record);

    int updateByPrimaryKey(OrgRoleRlt record);
}