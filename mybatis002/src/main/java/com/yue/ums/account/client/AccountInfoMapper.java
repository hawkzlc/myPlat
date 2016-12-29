package com.yue.ums.account.client;

import com.yue.ums.account.model.AccountInfo;

public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    AccountInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);
}