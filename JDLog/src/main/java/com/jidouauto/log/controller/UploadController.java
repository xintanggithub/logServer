package com.jidouauto.log.controller;

import com.alibaba.fastjson.JSON;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("UploadController")
@RequestMapping("/v1/upload")
@Api(description = "upload", tags = "upload")
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传文件", notes = "提供各种文件上传服务")
    public BaseResponse<String> uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) {
        BaseResponse<String> response = new BaseResponse<>();
        if (file.isEmpty()) {
            response.setResultCode(LogCode.RC_UPLOAD_FILE_ERROR.getCode());
            response.setResultMessage(LogCode.RC_UPLOAD_FILE_ERROR.getMessage());
            return response;
        }
        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字
        //文件存放路径
        String filePath = "/Users/tangxin/work/springCloud/serviceAddress/";
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            LOGGER.error("upload error : " + JSON.toJSONString(e));
        }
        // 返回图片的存放路径
        response.setData(filePath);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }


}
