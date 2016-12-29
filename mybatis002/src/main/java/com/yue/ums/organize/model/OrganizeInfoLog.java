package com.yue.ums.organize.model;

import java.util.Date;

public class OrganizeInfoLog {
    private Integer logId;

    private Integer orgId;

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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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