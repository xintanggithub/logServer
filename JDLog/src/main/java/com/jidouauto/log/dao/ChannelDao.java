package com.jidouauto.log.dao;

import com.jidouauto.log.model.ChannelEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChannelDao {

    List<ChannelEntity> getChannels();

}
