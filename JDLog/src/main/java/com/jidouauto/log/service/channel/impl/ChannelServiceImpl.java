package com.jidouauto.log.service.channel.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.base.LogCode;
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

    private BaseResponse checkParams(ChannelEntity channelEntity) {
        BaseResponse response = new BaseResponse();
        if (StringUtils.isEmpty(channelEntity.getChannelName())) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage() + " ->  channelName");
            return response;
        }
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<ListBaseData<ChannelEntity>> getChannels(int pageNum, int pageSize) {
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        BaseResponse<ListBaseData<ChannelEntity>> response = new BaseResponse<>();
        //查询渠道列表
        PageHelper.startPage(pageNum, pageSize);
        List<ChannelEntity> listData = channelDao.getChannels();
        if (listData == null) {
            response.setResultCode(LogCode.RC_RESULT_EMPTY.getCode());
            response.setResultMessage(LogCode.RC_RESULT_EMPTY.getMessage());
            return response;
        }
        PageInfo<ChannelEntity> pageInfo = new PageInfo(listData);
        //数据组装
        ListBaseData<ChannelEntity> channels = new ListBaseData<>();
        channels.setLists(pageInfo.getList());
        channels.setPageSize(pageInfo.getSize());
        channels.setTotalCount((int) pageInfo.getTotal());
        response.setData(channels);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<ChannelEntity> getChannel(int channelId) {
        BaseResponse<ChannelEntity> response = new BaseResponse<>();
        if (channelId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        ChannelEntity channelEntity = channelDao.getChannel(channelId);
        if (null == channelEntity) {
            response.setResultCode(LogCode.RC_RESULT_EMPTY.getCode());
            response.setResultMessage(LogCode.RC_RESULT_EMPTY.getMessage());
            return response;
        }
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setData(channelEntity);
        return response;
    }

    @Override
    public BaseResponse<ChannelEntity> getChannelByName(String channelName) {
        BaseResponse<ChannelEntity> response = new BaseResponse<>();
        if (StringUtils.isEmpty(channelName)) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        ChannelEntity channelEntity = channelDao.getChannelByName(channelName);
        if (null == channelEntity) {
            response.setResultCode(LogCode.RC_RESULT_EMPTY.getCode());
            response.setResultMessage(LogCode.RC_RESULT_EMPTY.getMessage());
            return response;
        }
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setData(channelEntity);
        return response;
    }

    @Override
    public BaseResponse<Integer> insert(ChannelEntity channelEntity) {
        BaseResponse<Integer> response = new BaseResponse<>();
        BaseResponse baseResponse = checkParams(channelEntity);
        if (LogCode.RC_SUCCESS.getCode() != baseResponse.getResultCode()) {
            return baseResponse;
        }
        channelDao.insert(channelEntity);
        response.setData(channelEntity.getChannelId());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        return response;
    }

    @Override
    public BaseResponse update(ChannelEntity channelEntity) {
        BaseResponse<Integer> response = new BaseResponse<>();
        if (channelEntity.getChannelId() <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage() + " ->  channelId");
            return response;
        }
        BaseResponse baseResponse = checkParams(channelEntity);
        if (LogCode.RC_SUCCESS.getCode() != baseResponse.getResultCode()) {
            return baseResponse;
        }
        channelDao.update(channelEntity);
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        return response;
    }

    @Override
    public BaseResponse delete(int channelId) {
        BaseResponse<ListBaseData<ChannelEntity>> response = new BaseResponse<>();
        if (channelId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        channelDao.delete(channelId);
        return response;
    }

}
