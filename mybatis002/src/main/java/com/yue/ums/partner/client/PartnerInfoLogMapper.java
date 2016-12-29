package com.yue.ums.partner.client;

import com.yue.ums.partner.model.PartnerInfoLog;

public interface PartnerInfoLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(PartnerInfoLog record);

    int insertSelective(PartnerInfoLog record);

    PartnerInfoLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(PartnerInfoLog record);

    int updateByPrimaryKey(PartnerInfoLog record);
}