package com.yue.ums.client;

import com.yue.ums.model.UserSms;

public interface UserSmsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSms record);

    int insertSelective(UserSms record);

    UserSms selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSms record);

    int updateByPrimaryKey(UserSms record);
}