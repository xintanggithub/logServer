package com.jidouauto.log.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.model.*;
import com.jidouauto.log.service.channel.ChannelService;
import com.jidouauto.log.service.info.InfoService;
import com.jidouauto.log.service.log.LogService;
import com.jidouauto.log.service.version.VersionService;
import com.jidouauto.log.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.jidouauto.log.model.AppInfoByHeaderEntity.*;

@RestController("UploadController")
@RequestMapping("/v1/upload")
@Api(description = "upload", tags = "upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ChannelService channelService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private VersionService versionService;
    @Autowired
    private LogService logService;

    @Value("${market.log.file.path}")
    private String path;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传文件", notes = "提供各种文件上传服务")
    public BaseResponse<String> uploadFile(@RequestParam(value = "file", required = true) MultipartFile file
            , HttpServletRequest request) {
        AppInfoByHeaderEntity headers = new AppInfoByHeaderEntity();
        BaseResponse<String> response = new BaseResponse<>();
        if (request != null) {
            headers.setAppName(request.getHeader(X_AUTH_APP_NAME));
            headers.setChannel(request.getHeader(X_AUTH_CHANNEL));
            headers.setDeviceType(request.getHeader(X_AUTH_DEVICE_TYPE));
            headers.setPackageName(request.getHeader(X_AUTH_PACKAGE_NAME));
            headers.setVersionCode(StringUtils.isEmpty(request.getHeader(X_AUTH_VERSION_CODE)) ? 0
                    : Integer.valueOf(request.getHeader(X_AUTH_VERSION_CODE)));
            headers.setVersionName(request.getHeader(X_AUTH_VERSION_NAME));

            if (StringUtils.isEmpty(headers.getAppName()) || StringUtils.isEmpty(headers.getChannel())
                    || StringUtils.isEmpty(headers.getPackageName()) || StringUtils.isEmpty(headers.getVersionName())
                    || headers.getVersionCode() <= 0) {
                response.setResultCode(LogCode.RC_HEAD_PARAMETER_ERROR.getCode());
                response.setResultMessage(LogCode.RC_HEAD_PARAMETER_ERROR.getMessage());
                return response;
            }
        }
        if (file.isEmpty()) {
            response.setResultCode(LogCode.RC_UPLOAD_FILE_ERROR.getCode());
            response.setResultMessage(LogCode.RC_UPLOAD_FILE_ERROR.getMessage());
            return response;
        }
        String contentType = file.getContentType();   //文件类型
        String fileName = file.getOriginalFilename();  //名字
        LOGGER.info("文件类型:" + contentType + "    文件名称:" + fileName);
        //文件存放路径
        String filePath = path;
        LOGGER.info("存放路径:" + path);
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            LOGGER.error("upload error : " + JSON.toJSONString(e));
        }
        checkLogVersion(headers, filePath, fileName);
        // 返回存放路径
        response.setData(filePath);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    private void checkLogVersion(AppInfoByHeaderEntity headers, String filePath, String filename) {
        //查询渠道
        String channel = headers.getChannel();
        BaseResponse<ChannelEntity> channelResponse = channelService.getChannelByName(channel);
        if (null == channelResponse.getData()) {//如果渠道为空
            ChannelEntity channelEntity = new ChannelEntity();
            channelEntity.setChannelName(channel);
            channelEntity.setCreateTime(System.currentTimeMillis() / 1000);
            channelEntity.setUpdateTime(System.currentTimeMillis() / 1000);
            BaseResponse<Integer> channelInsertResponse = channelService.insert(channelEntity);
            if (channelInsertResponse.getData() != 0) {
                channelEntity.setChannelId(channelInsertResponse.getData());
                channelResponse.setData(channelEntity);
            } else {
                LOGGER.error("insert channel error ! channel =>" + channel);
                return;
            }
        }
        //查询应用
        String appName = headers.getAppName();
        String packageName = headers.getPackageName();
        BaseResponse<InfoEntity> infoResponse = infoService.getInfoByPackage(channelResponse.getData().getChannelId(),
                packageName);
        if (null == infoResponse.getData()) {
            InfoEntity infoEntity = new InfoEntity();
            infoEntity.setAppName(appName);
            infoEntity.setAppPackage(packageName);
            infoEntity.setChannelId(channelResponse.getData().getChannelId());
            infoEntity.setChannelName(channelResponse.getData().getChannelName());
            infoEntity.setCreateTime(System.currentTimeMillis() / 1000);
            infoEntity.setUpdateTime(System.currentTimeMillis() / 1000);
            BaseResponse<Integer> infoInsertResponse = infoService.insert(infoEntity);
            if (infoInsertResponse.getData() != 0) {
                infoEntity.setAppId(infoInsertResponse.getData());
                infoResponse.setData(infoEntity);
            } else {
                LOGGER.error("insert info error !  appInfo:" + appName + "  -  " + packageName);
                return;
            }
        }
        //查询版本
        int versionCode = headers.getVersionCode();
        String versionName = headers.getVersionName();
        BaseResponse<VersionEntity> versionResponse = versionService.getVersionByVersionName(infoResponse.getData().getAppId(),
                versionName);
        if (null == versionResponse.getData()) {
            VersionEntity versionEntity = new VersionEntity();
            versionEntity.setAppId(infoResponse.getData().getAppId());
            versionEntity.setVersionCode(versionCode);
            versionEntity.setVersionName(versionName);
            versionEntity.setCreateTime(System.currentTimeMillis() / 1000);
            versionEntity.setUpdateTime(System.currentTimeMillis() / 1000);
            BaseResponse<Integer> versionInsertResponse = versionService.insert(versionEntity);
            if (versionInsertResponse.getData() != 0) {
                versionEntity.setVersionId(versionInsertResponse.getData());
                versionResponse.setData(versionEntity);
            } else {
                LOGGER.error("insert version error !  versionCode:" + versionCode + "  versionName:  " + versionName);
                return;
            }
        }
        //查询日志
        BaseResponse<LogEntity> logResponse = logService.getLogByUrl(versionResponse.getData().getVersionId(),
                filePath);
        if (null == logResponse.getData()) {
            LogEntity logEntity = new LogEntity();
            logEntity.setLogName(filename);
            logEntity.setLogUrl(filePath + filename);
            logEntity.setVersionId(versionResponse.getData().getVersionId());
            logEntity.setCreateTime(System.currentTimeMillis() / 1000);
            logEntity.setUpdateTime(System.currentTimeMillis() / 1000);
            BaseResponse<Integer> logInsertResponse = logService.insert(logEntity);
            if (logInsertResponse.getData() != 0) {
                LOGGER.info("insert log success ! id:" + logInsertResponse.getData());
            } else {
                LOGGER.error("insert log error !  logFile:" + filePath);
                return;
            }
        } else {
            LogEntity logEntity = logResponse.getData();
            logEntity.setUpdateTime(0L);
            logService.update(logEntity);
        }
    }

}
