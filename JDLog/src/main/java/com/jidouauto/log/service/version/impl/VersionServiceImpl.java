package com.jidouauto.log.service.version.impl;

import com.alibaba.druid.util.StringUtils;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.dao.VersionDao;
import com.jidouauto.log.model.InfoEntity;
import com.jidouauto.log.model.VersionEntity;
import com.jidouauto.log.service.version.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "VersionService")
public class VersionServiceImpl implements VersionService {

    @Autowired
    VersionDao versionDao;

    @Override
    public BaseResponse<ListBaseData<VersionEntity>> getVersions(int page, int pageSize) {
        BaseResponse<ListBaseData<VersionEntity>> response = new BaseResponse<>();
        ListBaseData<VersionEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<VersionEntity> lists = versionDao.getVersions((page - 1) * pageSize, pageSize);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        return response;
    }

    @Override
    public BaseResponse<ListBaseData<VersionEntity>> getVersionsByInfoId(int page, int pageSize, int appId) {
        BaseResponse<ListBaseData<VersionEntity>> response = new BaseResponse<>();
        if (appId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        ListBaseData<VersionEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<VersionEntity> lists = versionDao.getVersionsByInfoId((page - 1) * pageSize, pageSize, appId);
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<VersionEntity> getVersionByVersionId(int versionId) {
        BaseResponse<VersionEntity> response = new BaseResponse<>();
        if (versionId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        VersionEntity versionEntity = versionDao.getVersionByVersionId(versionId);
        response.setData(versionEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<VersionEntity> getVersionByVersionName(int appId, String versionName) {
        BaseResponse<VersionEntity> response = new BaseResponse<>();
        if (StringUtils.isEmpty(versionName) || appId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        VersionEntity versionEntity = versionDao.getVersionByVersionName(appId, versionName);
        response.setData(versionEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<Integer> insert(VersionEntity versionEntity) {
        BaseResponse<Integer> response = new BaseResponse();
        if (null == versionEntity || StringUtils.isEmpty(versionEntity.getVersionName())
                || versionEntity.getAppId() <= 0 || versionEntity.getVersionCode() <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        versionDao.insert(versionEntity);
        response.setData(versionEntity.getVersionId());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse update(VersionEntity versionEntity) {
        BaseResponse response = new BaseResponse();
        if (null == versionEntity) {
            versionEntity = new VersionEntity();
        }
        versionDao.update(versionEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse delete(int versionId) {
        BaseResponse<InfoEntity> response = new BaseResponse<>();
        if (versionId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        versionDao.delete(versionId);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }
}
