package com.jidouauto.log.service.log.impl;

import com.alibaba.druid.util.StringUtils;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.dao.LogDao;
import com.jidouauto.log.model.LogEntity;
import com.jidouauto.log.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "LogService")
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public BaseResponse<ListBaseData<LogEntity>> getLogs(int page, int pageSize) {
        BaseResponse<ListBaseData<LogEntity>> response = new BaseResponse<>();
        ListBaseData<LogEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<LogEntity> lists = logDao.getLogs((page - 1) * pageSize, pageSize);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        return response;
    }

    @Override
    public BaseResponse<ListBaseData<LogEntity>> getLogsByVersionId(int page, int pageSize, int versionId) {
        BaseResponse<ListBaseData<LogEntity>> response = new BaseResponse<>();
        if (versionId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        ListBaseData<LogEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<LogEntity> lists = logDao.getLogsByVersionId((page - 1) * pageSize, pageSize, versionId);
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<LogEntity> getLogById(int logId) {
        BaseResponse<LogEntity> response = new BaseResponse<>();
        if (logId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        LogEntity logEntity = logDao.getLogById(logId);
        response.setData(logEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<LogEntity> getLogByUrl(int versionId, String logUrl) {
        BaseResponse<LogEntity> response = new BaseResponse<>();
        if (versionId <= 0 || StringUtils.isEmpty(logUrl)) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        LogEntity logEntity = logDao.getLogByUrl(versionId, logUrl);
        response.setData(logEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<LogEntity> getLogByLogName(int versionId, String logName) {
        BaseResponse<LogEntity> response = new BaseResponse<>();
        if (versionId <= 0 || StringUtils.isEmpty(logName)) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        LogEntity logEntity = logDao.getLogByLogName(versionId, logName);
        response.setData(logEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<Integer> insert(LogEntity logEntity) {
        BaseResponse<Integer> response = new BaseResponse();
        if (null == logEntity || StringUtils.isEmpty(logEntity.getLogName())
                || logEntity.getVersionId() <= 0 || StringUtils.isEmpty(logEntity.getLogUrl())) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        logDao.insert(logEntity);
        response.setData(logEntity.getVersionId());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse update(LogEntity logEntity) {
        BaseResponse response = new BaseResponse();
        if (null == logEntity) {
            logEntity = new LogEntity();
        }
        logDao.update(logEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse delete(int logId) {
        BaseResponse<LogEntity> response = new BaseResponse<>();
        if (logId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        logDao.delete(logId);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }
}
