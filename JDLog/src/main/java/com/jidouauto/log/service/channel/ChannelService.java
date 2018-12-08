package com.jidouauto.log.service.channel;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.ChannelEntity;

public interface ChannelService {

    BaseResponse<ListBaseData<ChannelEntity>> getChannels(int pageNum, int pageSize);

    BaseResponse<ChannelEntity> getChannel(int channelId);

    BaseResponse<Integer> insert(ChannelEntity channelEntity);

    BaseResponse update(ChannelEntity channelEntity);

    BaseResponse delete(int channelId);

}
