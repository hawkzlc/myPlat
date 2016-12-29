package com.yue.ums.organize.client;

import com.yue.ums.organize.model.OrgKindRlt;

public interface OrgKindRltMapper {
    int deleteByPrimaryKey(Integer relId);

    int insert(OrgKindRlt record);

    int insertSelective(OrgKindRlt record);

    OrgKindRlt selectByPrimaryKey(Integer relId);

    int updateByPrimaryKeySelective(OrgKindRlt record);

    int updateByPrimaryKey(OrgKindRlt record);
}