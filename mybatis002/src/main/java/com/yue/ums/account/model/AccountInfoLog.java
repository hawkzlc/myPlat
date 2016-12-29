package com.yue.ums.account.model;

import java.util.Date;

public class AccountInfoLog {
    private Integer logId;

    private Integer userId;

    private Integer operateType;

    private Integer status;

    private Date operateDatetime;

    private Integer operateBy;

    private String note;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    public Integer getOperateBy() {
        return operateBy;
    }

    public void setOperateBy(Integer operateBy) {
        this.operateBy = operateBy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}