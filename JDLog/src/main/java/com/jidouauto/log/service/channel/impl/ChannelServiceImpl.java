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
    public PageInfo<ChannelEntity> getChannels(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChannelEntity> response = channelDao.getChannels();
        return new PageInfo(response);
    }

    @Override
    public ChannelEntity getChannel(int channelId) {
        return channelDao.getChannel(channelId);
    }

    @Override
    public void insert(ChannelEntity channelEntity) {
        channelDao.insert(channelEntity);
    }

    @Override
    public void update(ChannelEntity channelEntity) {
        channelDao.update(channelEntity);
    }

    @Override
    public void delete(int channelId) {
        channelDao.delete(channelId);
    }

}
