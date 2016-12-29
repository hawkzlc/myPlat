package com.yue.ums.model;

import java.util.Date;

public class WareKind {
    private Integer kindId;

    private Integer kindCode;

    private String kindName;

    private String kindDesc;

    private Integer parentId;

    private Integer sortId;

    private Integer createdBy;

    private Date created;

    private Integer updatedBy;

    private Date update;

    private String note;

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getKindCode() {
        return kindCode;
    }

    public void setKindCode(Integer kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindDesc() {
        return kindDesc;
    }

    public void setKindDesc(String kindDesc) {
        this.kindDesc = kindDesc;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}