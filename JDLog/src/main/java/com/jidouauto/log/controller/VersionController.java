package com.jidouauto.log.controller;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.VersionEntity;
import com.jidouauto.log.service.version.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("VersionController")
@RequestMapping("/v1/version")
@Api(description = "version", tags = "version")
public class VersionController {

    @Autowired
    VersionService versionService;

    @RequestMapping(value = "/getVersions", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有的版本信息", notes = "获取所有的版本信息")
    public BaseResponse<ListBaseData<VersionEntity>> getVersions(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                                 @RequestParam(value = "pageNum", required = true) int pageNum,
                                                                 @ApiParam(required = true, name = "pageSize", value = "条数")
                                                                 @RequestParam(value = "pageSize", required = true) int pageSize) {
        return versionService.getVersions(pageNum, pageSize);
    }

    @RequestMapping(value = "/getVersionsByInfoId", method = RequestMethod.GET)
    @ApiOperation(value = "获取对应应用的所有版本信息", notes = "获取对应应用的所有版本信息")
    public BaseResponse<ListBaseData<VersionEntity>> getVersionsByInfoId(@ApiParam(required = true, name = "pageNum", value = "页数")
                                                                         @RequestParam(value = "pageNum", required = true) int pageNum,
                                                                         @ApiParam(required = true, name = "pageSize", value = "条数")
                                                                         @RequestParam(value = "pageSize", required = true) int pageSize,
                                                                         @ApiParam(required = true, name = "appId", value = "应用ID")
                                                                         @RequestParam(value = "appId", required = true) int appId) {
        return versionService.getVersionsByInfoId(pageNum, pageSize, appId);
    }

    @RequestMapping(value = "/getVersionByVersionId", method = RequestMethod.GET)
    @ApiOperation(value = "根据版本ID获取版本信息", notes = "根据版本ID获取版本信息")
    public BaseResponse<VersionEntity> getVersionByVersionId(@ApiParam(required = true, name = "versionId", value = "版本ID")
                                                             @RequestParam(value = "versionId", required = true) int versionId) {
        return versionService.getVersionByVersionId(versionId);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "插入版本信息", notes = "插入版本信息")
    public BaseResponse<Integer> insert(@RequestBody VersionEntity versionEntity) {
        return versionService.insert(versionEntity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新版本信息", notes = "更新版本信息")
    public BaseResponse update(@RequestBody VersionEntity versionEntity) {
        return versionService.update(versionEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除版本信息", notes = "删除版本信息")
    public BaseResponse delete(@ApiParam(required = true, name = "versionId", value = "版本ID")
                               @RequestParam(value = "versionId", required = true) int versionId) {
        return versionService.delete(versionId);
    }


}
