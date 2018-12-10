package com.jidouauto.log.model;

public class LogEntity {

    private int logId;//	INT	10	不可空	日志ID，表主键自增长
    private int versionId;//	INT	10	不可空	版本ID
    private String logName;//	CHAR	255	不可空	日志文件名
    private String logUrl;//	CHAR	255	不可空	日志文件url
    private long createTime;//	DATETIME	20	不可空	创建时间
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
