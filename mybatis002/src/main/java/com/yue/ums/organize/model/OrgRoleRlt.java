package com.yue.ums.organize.model;

import java.util.Date;

public class OrgRoleRlt {
    private Integer rltId;

    private Integer orgId;

    private Integer roleId;

    private Boolean isAuthor;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    private String note;

    public Integer getRltId() {
        return rltId;
    }

    public void setRltId(Integer rltId) {
        this.rltId = rltId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}