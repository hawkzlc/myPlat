package com.yue.ums.client;

import com.yue.ums.model.WareKind;

public interface WareKindMapper {
    int deleteByPrimaryKey(Integer kindId);

    int insert(WareKind record);

    int insertSelective(WareKind record);

    WareKind selectByPrimaryKey(Integer kindId);

    int updateByPrimaryKeySelective(WareKind record);

    int updateByPrimaryKey(WareKind record);
}