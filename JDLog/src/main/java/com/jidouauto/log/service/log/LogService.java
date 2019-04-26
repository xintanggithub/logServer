package com.jidouauto.log.service.log;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.LogEntity;

public interface LogService {

    BaseResponse<ListBaseData<LogEntity>> getLogs(int page, int pageSize);

    BaseResponse<ListBaseData<LogEntity>> getLogsByVersionId(int page, int pageSize, int versionId);

    BaseResponse<LogEntity> getLogById(int logId);

    BaseResponse<LogEntity> getLogByUrl(int versionId, String logUrl);

    BaseResponse<LogEntity> getLogByLogName(int versionId, String logName);

    //插入版本信息
    BaseResponse<Integer> insert(LogEntity logEntity);

    //更新版本信息
    BaseResponse update(LogEntity logEntity);

    //删除版本信息
    BaseResponse delete(int logId);

}
