package com.jidouauto.log.service.channel;

import com.github.pagehelper.PageInfo;
import com.jidouauto.log.model.ChannelEntity;

public interface ChannelService {

    PageInfo<ChannelEntity> getChannels(int pageNum, int pageSize);

    ChannelEntity getChannel(int channelId);

    void insert(ChannelEntity channelEntity);

    void update(ChannelEntity channelEntity);

    void delete(int channelId);
    
}
