package com.jidouauto.log.controller;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.InfoEntity;
import com.jidouauto.log.service.info.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("InfoController")
@RequestMapping("/v1/info")
@Api(description = "info", tags = "info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @RequestMapping(value = "/getInfos", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有应用信息", notes = "获取所有应用信息")
    public BaseResponse<ListBaseData<InfoEntity>> getInfos(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                           @RequestParam(value = "pageNum", required = true) int pageNum,
                                                           @ApiParam(required = true, name = "pageSize", value = "条数")
                                                           @RequestParam(value = "pageSize", required = true) int pageSize) {
        return infoService.getInfos(pageNum, pageSize);
    }

    @RequestMapping(value = "/getInfosByChannel", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有应用信息", notes = "获取所有应用信息")
    public BaseResponse<ListBaseData<InfoEntity>> getInfosByChannel(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                                    @RequestParam(value = "pageNum", required = true) int pageNum,
                                                                    @ApiParam(required = true, name = "pageSize", value = "条数")
                                                                    @RequestParam(value = "pageSize", required = true) int pageSize,
                                                                    @ApiParam(required = true, name = "channelId", value = "渠道ID")
                                                                    @RequestParam(value = "channelId", required = true) int channelId) {
        return infoService.getInfosByChannel(channelId, pageNum, pageSize);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取应用信息", notes = "获取应用信息")
    public BaseResponse<InfoEntity> getInfo(@ApiParam(required = true, name = "appId", value = "应用ID")
                                            @RequestParam(value = "appId", required = true) int appId) {
        return infoService.getInfo(appId);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "插入应用信息", notes = "插入应用信息")
    public BaseResponse<Integer> insert(@RequestBody InfoEntity infoEntity) {
        return infoService.insert(infoEntity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新应用信息", notes = "更新应用信息")
    public BaseResponse update(@RequestBody InfoEntity infoEntity) {
        return infoService.update(infoEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除应用信息", notes = "删除应用信息")
    public BaseResponse delete(@ApiParam(required = true, name = "appId", value = "应用ID")
                               @RequestParam(value = "appId", required = true) int appId) {
        return infoService.delete(appId);
    }

}
