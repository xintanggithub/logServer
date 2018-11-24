package com.jidouauto.log.service.channel;

import com.github.pagehelper.PageInfo;
import com.jidouauto.log.model.ChannelEntity;

import java.util.List;

public interface ChannelService {

    PageInfo<ChannelEntity> getChannels();

}
