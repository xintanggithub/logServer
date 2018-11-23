package com.jidouauto.log.model;

public class ChannelEntity {
    private int channelId;//	INT	10	不可空	渠道ID，表主键自增长
    private String channelName;//	CHAR	255	不可空	渠道名

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
