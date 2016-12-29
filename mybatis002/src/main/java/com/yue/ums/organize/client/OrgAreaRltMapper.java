package com.yue.ums.organize.client;

import com.yue.ums.organize.model.OrgAreaRlt;

public interface OrgAreaRltMapper {
    int deleteByPrimaryKey(Integer relId);

    int insert(OrgAreaRlt record);

    int insertSelective(OrgAreaRlt record);

    OrgAreaRlt selectByPrimaryKey(Integer relId);

    int updateByPrimaryKeySelective(OrgAreaRlt record);

    int updateByPrimaryKey(OrgAreaRlt record);
}