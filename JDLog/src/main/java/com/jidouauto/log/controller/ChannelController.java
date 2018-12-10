package com.jidouauto.log.controller;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
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
        return channelService.getChannels(pageNum, pageSize);
    }

    @RequestMapping(value = "/getChannel", method = RequestMethod.GET)
    @ApiOperation(value = "根据渠道ID获取渠道", notes = "根据渠道ID获取渠道")
    public BaseResponse<ChannelEntity> getChannelById(@ApiParam(required = true, name = "channelId", value = "渠道ID")
                                                      @RequestParam(value = "channelId", required = true) int channelId) {
        return channelService.getChannel(channelId);
    }

    @RequestMapping(value = "/getChannelByName", method = RequestMethod.GET)
    @ApiOperation(value = "根据渠道名获取渠道", notes = "根据渠道名获取渠道")
    public BaseResponse<ChannelEntity> getChannelByName(@ApiParam(required = true, name = "channelName", value = "渠道名")
                                                        @RequestParam(value = "channelName", required = true) String channelName) {
        return channelService.getChannelByName(channelName);
    }

    @RequestMapping(value = "/insertChannel", method = RequestMethod.POST)
    @ApiOperation(value = "上传渠道", notes = "上传渠道")
    public BaseResponse<Integer> insert(@RequestBody ChannelEntity channelEntity) {
        return channelService.insert(channelEntity);
    }

    @RequestMapping(value = "/updateChannel", method = RequestMethod.POST)
    @ApiOperation(value = "更新渠道信息", notes = "更新渠道信息")
    public BaseResponse update(@RequestBody ChannelEntity channelEntity) {
        return channelService.update(channelEntity);
    }

    @RequestMapping(value = "/deleteChannel", method = RequestMethod.GET)
    @ApiOperation(value = "删除渠道信息", notes = "删除渠道信息")
    public BaseResponse delete(@ApiParam(required = true, name = "channelId", value = "渠道ID")
                               @RequestParam(value = "channelId", required = true) int channelId) {
        return channelService.delete(channelId);
    }

}
