package com.jidouauto.log.controller;

import com.github.pagehelper.PageInfo;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.model.ChannelEntity;
import com.jidouauto.log.service.channel.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("ChannelController")
@RequestMapping("/v1/channel")
@Api(description = "channel", tags = "channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @RequestMapping(value = "/getChannels", method = RequestMethod.GET)
    @ApiOperation(value = "获取渠道", notes = "获取渠道")
    public BaseResponse<ListBaseData<ChannelEntity>> getChannel(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                                @RequestParam(value = "pageNum", required = true) int pageNum,
                                                                @ApiParam(required = true, name = "pageSize", value = "条数")
                                                                @RequestParam(value = "pageSize", required = true) int pageSize) {
        BaseResponse<ListBaseData<ChannelEntity>> response = new BaseResponse<>();
        //查询渠道列表
        PageInfo<ChannelEntity> pageInfo = channelService.getChannels(pageNum, pageSize);
        if (null == pageInfo) {
            response.setResultCode(LogCode.RC_RESULT_EMPTY.getCode());
            response.setResultMessage(LogCode.RC_RESULT_EMPTY.getMessage());
            return response;
        }
        //数据组装
        ListBaseData<ChannelEntity> channels = new ListBaseData<>();
        channels.setLists(pageInfo.getList());
        channels.setPageNum(pageInfo.getPageNum());
        channels.setPageSize(pageInfo.getSize());
        channels.setTotalCount((int) pageInfo.getTotal());
        response.setData(channels);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @RequestMapping(value = "/getChannel", method = RequestMethod.GET)
    @ApiOperation(value = "根据渠道ID获取渠道", notes = "根据渠道ID获取渠道")
    public BaseResponse<ChannelEntity> getChannelById(@ApiParam(required = true, name = "channelId", value = "渠道ID")
                                                      @RequestParam(value = "channelId", required = true) int channelId) {
        BaseResponse<ChannelEntity> response = new BaseResponse<>();
        ChannelEntity channelEntity = channelService.getChannel(channelId);
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setData(channelEntity);
        return response;
    }

    @RequestMapping(value = "/insertChannel", method = RequestMethod.POST)
    @ApiOperation(value = "上传渠道", notes = "上传渠道")
    public BaseResponse insert(@RequestBody ChannelEntity channelEntity) {
        BaseResponse<ListBaseData<ChannelEntity>> response = new BaseResponse<>();
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        channelService.insert(channelEntity);
        return response;
    }


}
