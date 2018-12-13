package com.jidouauto.log.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "版本信息")
public class VersionEntity {
    @ApiModelProperty(value = "版本ID")
    private int versionId;//	INT	10	不可空	版本ID，表主键自增长
    @ApiModelProperty(value = "应用ID")
    private int appId;//	INT	10	不可空	应用ID
    @ApiModelProperty(value = "版本号")
    private int versionCode;//	INT	10	不可空	版本号
    @ApiModelProperty(value = "版本名")
    private String versionName;//	CHAR	255	不可空	版本名
    @ApiModelProperty(value = "创建时间")
    private long createTime;//	DATETIME	20	不可空	创建时间
    @ApiModelProperty(value = "更新时间")
    private long updateTime;//	DATETIME

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
