package com.yue.ums.partner.client;

import com.yue.ums.partner.model.PartnerInfo;

public interface PartnerInfoMapper {
    int deleteByPrimaryKey(Integer partnerId);

    int insert(PartnerInfo record);

    int insertSelective(PartnerInfo record);

    PartnerInfo selectByPrimaryKey(Integer partnerId);

    int updateByPrimaryKeySelective(PartnerInfo record);

    int updateByPrimaryKey(PartnerInfo record);
}