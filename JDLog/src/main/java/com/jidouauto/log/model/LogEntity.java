package com.jidouauto.log.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "日志信息")
public class LogEntity {
    @ApiModelProperty(value = "日志ID")
    private int logId;//	INT	10	不可空	日志ID，表主键自增长
    @ApiModelProperty(value = "版本ID")
    private int versionId;//	INT	10	不可空	版本ID
    @ApiModelProperty(value = "日志文件名")
    private String logName;//	CHAR	255	不可空	日志文件名
    @ApiModelProperty(value = "日志文件url")
    private String logUrl;//	CHAR	255	不可空	日志文件url
    @ApiModelProperty(value = "创建时间")
    private long createTime;//	DATETIME	20	不可空	创建时间
    @ApiModelProperty(value = "更新时间")
    private long updateTime;//	DATETIME	20	可空	更新时间

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
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
