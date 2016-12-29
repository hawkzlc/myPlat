package com.yue.ums.account.client;

import com.yue.ums.account.model.AccountInfoLog;

public interface AccountInfoLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(AccountInfoLog record);

    int insertSelective(AccountInfoLog record);

    AccountInfoLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(AccountInfoLog record);

    int updateByPrimaryKey(AccountInfoLog record);
}