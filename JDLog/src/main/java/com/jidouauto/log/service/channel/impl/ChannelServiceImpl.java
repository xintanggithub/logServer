package com.jidouauto.log.service.channel.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidouauto.log.dao.ChannelDao;
import com.jidouauto.log.model.ChannelEntity;
import com.jidouauto.log.service.channel.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "ChannelService")
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelDao channelDao;

    @Override
    public PageInfo<ChannelEntity> getChannels() {
        PageHelper.startPage(1, 10);
        List<ChannelEntity> response = channelDao.getChannels();
        return new PageInfo(response);
    }
}
