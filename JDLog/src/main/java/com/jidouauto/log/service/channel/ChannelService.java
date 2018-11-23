package com.jidouauto.log.service.channel;

import com.github.pagehelper.PageInfo;
import com.jidouauto.log.model.ChannelEntity;

public interface ChannelService {

    PageInfo<ChannelEntity> getChannels();
}
