package com.jidouauto.log.model;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "应用信息")
public class InfoEntity {

    private int appId;//	INT	10	不可空	应用ID，表主键自增长
    private int channelId;//	INT	10	不可空	渠道ID
    private String appName;//	CHAR	255	可空	应用名
    private String channelName;// char 255 渠道名
    private String appPackage;//	CHAR	255	不可空	应用包名
    private long createTime;//	DATETIME	20	不可空	创建时间
    private long updateTime;//	DATETIME	20	可空	更新时间

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
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
