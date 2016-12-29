package com.yue.ums.account.model;

import java.util.Date;

public class AccountPassword {
    private Integer id;

    private Integer userId;

    private String passhash;

    private String lastPasshash;

    private Integer errorTimes;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public String getLastPasshash() {
        return lastPasshash;
    }

    public void setLastPasshash(String lastPasshash) {
        this.lastPasshash = lastPasshash;
    }

    public Integer getErrorTimes() {
        return errorTimes;
    }

    public void setErrorTimes(Integer errorTimes) {
        this.errorTimes = errorTimes;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}