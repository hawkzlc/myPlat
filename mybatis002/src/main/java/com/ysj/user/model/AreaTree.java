package com.ysj.user.model;

public class AreaTree {
    private Integer areaId;

    private String areaCode;

    private String areaLevel;

    private String areaName;

    private String parentAreaCode;

    private Integer parentId;

    private String keyWords;

    private String areaRegionCode;

    private String areaZipCode;

    private String areaPhoneCode;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel == null ? null : areaLevel.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getParentAreaCode() {
        return parentAreaCode;
    }

    public void setParentAreaCode(String parentAreaCode) {
        this.parentAreaCode = parentAreaCode == null ? null : parentAreaCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public String getAreaRegionCode() {
        return areaRegionCode;
    }

    public void setAreaRegionCode(String areaRegionCode) {
        this.areaRegionCode = areaRegionCode == null ? null : areaRegionCode.trim();
    }

    public String getAreaZipCode() {
        return areaZipCode;
    }

    public void setAreaZipCode(String areaZipCode) {
        this.areaZipCode = areaZipCode == null ? null : areaZipCode.trim();
    }

    public String getAreaPhoneCode() {
        return areaPhoneCode;
    }

    public void setAreaPhoneCode(String areaPhoneCode) {
        this.areaPhoneCode = areaPhoneCode == null ? null : areaPhoneCode.trim();
    }
}