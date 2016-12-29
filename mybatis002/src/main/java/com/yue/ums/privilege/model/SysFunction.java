package com.yue.ums.privilege.model;

import java.util.Date;

public class SysFunction {
    private Integer funcId;

    private String funcCode;

    private String name;

    private String funcDesc;

    private Integer parentId;

    private String funcMd5;

    private Integer funcLevel;

    private Integer funcSeq;

    private String viewname;

    private String funcIco;

    private String funcArg;

    private Integer funcType;

    private Date createTime;

    private Date updateTime;

    private Integer createBy;

    private Integer updateBy;

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getFuncMd5() {
        return funcMd5;
    }

    public void setFuncMd5(String funcMd5) {
        this.funcMd5 = funcMd5;
    }

    public Integer getFuncLevel() {
        return funcLevel;
    }

    public void setFuncLevel(Integer funcLevel) {
        this.funcLevel = funcLevel;
    }

    public Integer getFuncSeq() {
        return funcSeq;
    }

    public void setFuncSeq(Integer funcSeq) {
        this.funcSeq = funcSeq;
    }

    public String getViewname() {
        return viewname;
    }

    public void setViewname(String viewname) {
        this.viewname = viewname;
    }

    public String getFuncIco() {
        return funcIco;
    }

    public void setFuncIco(String funcIco) {
        this.funcIco = funcIco;
    }

    public String getFuncArg() {
        return funcArg;
    }

    public void setFuncArg(String funcArg) {
        this.funcArg = funcArg;
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
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
}