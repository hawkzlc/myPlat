package com.yue.ums.account.client;

import com.yue.ums.account.model.AccountPassword;

public interface AccountPasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountPassword record);

    int insertSelective(AccountPassword record);

    AccountPassword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountPassword record);

    int updateByPrimaryKey(AccountPassword record);
}