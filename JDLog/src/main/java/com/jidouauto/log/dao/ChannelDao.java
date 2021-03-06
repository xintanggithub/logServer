package com.jidouauto.log.dao;

import com.jidouauto.log.model.ChannelEntity;

import java.util.List;

public interface ChannelDao {

    //获取所有渠道
    List<ChannelEntity> getChannels();

    //根据ID获取渠道信息
    ChannelEntity getChannel(int channelId);

    //根据渠道名获取渠道信息
    ChannelEntity getChannelByName(String channelName);

    //插入渠道
    void insert(ChannelEntity channelEntity);

    //更新渠道
    void update(ChannelEntity channelEntity);

    //删除渠道信息
    void delete(int channelId);

}
