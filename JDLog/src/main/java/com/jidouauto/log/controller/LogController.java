package com.jidouauto.log.controller;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.LogEntity;
import com.jidouauto.log.service.log.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("LogController")
@RequestMapping("/v1/log")
@Api(description = "log", tags = "log")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping(value = "/getLogs", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有的日志", notes = "获取所有的日志")
    public BaseResponse<ListBaseData<LogEntity>> getLogs(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                         @RequestParam(value = "pageNum", required = true) int pageNum,
                                                         @ApiParam(required = true, name = "pageSize", value = "条数")
                                                         @RequestParam(value = "pageSize", required = true) int pageSize) {
        return logService.getLogs(pageNum, pageSize);
    }

    @RequestMapping(value = "/getLogsByVersionId", method = RequestMethod.GET)
    @ApiOperation(value = "获取对应版本的所有日志", notes = "获取对应版本的所有日志")
    public BaseResponse<ListBaseData<LogEntity>> getLogsByVersionId(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                                    @RequestParam(value = "pageNum", required = true) int pageNum,
                                                                    @ApiParam(required = true, name = "pageSize", value = "条数")
                                                                    @RequestParam(value = "pageSize", required = true) int pageSize,
                                                                    @ApiParam(required = true, name = "versionId", value = "版本ID")
                                                                    @RequestParam(value = "versionId", required = true) int versionId) {
        return logService.getLogsByVersionId(pageNum, pageSize, versionId);
    }

    @RequestMapping(value = "/getLogById", method = RequestMethod.GET)
    @ApiOperation(value = "根据日志ID获取日志", notes = "根据日志ID获取日志")
    public BaseResponse<LogEntity> getLogById(@ApiParam(required = true, name = "logID", value = "日志ID")
                                              @RequestParam(value = "logID", required = true) int logID) {
        return logService.getLogById(logID);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "插入日志信息", notes = "插入日志信息")
    public BaseResponse<Integer> insert(@RequestBody LogEntity logEntity) {
        return logService.insert(logEntity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新版本信息", notes = "更新版本信息")
    public BaseResponse update(@RequestBody LogEntity logEntity) {
        return logService.update(logEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除日志信息", notes = "删除日志信息")
    public BaseResponse delete(@ApiParam(required = true, name = "LogId", value = "日志ID")
                               @RequestParam(value = "LogId", required = true) int logID) {
        return logService.delete(logID);
    }

}
