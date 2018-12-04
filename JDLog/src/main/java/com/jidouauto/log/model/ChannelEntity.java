package com.jidouauto.log.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "渠道实体类")
public class ChannelEntity {
    @ApiModelProperty(value = "渠道ID")
    private int channelId;//	INT	10	不可空	渠道ID，表主键自增长
    @ApiModelProperty(value = "渠道名")
    private String channelName;//	CHAR	255	不可空	渠道名
    @ApiModelProperty(value = "创建时间")
    private long createTime;
    @ApiModelProperty(value = "更新时间")
    private long updateTime;

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

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
