package com.jidouauto.log.service.info.impl;

import com.alibaba.druid.util.StringUtils;
import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.base.LogCode;
import com.jidouauto.log.dao.InfoDao;
import com.jidouauto.log.model.InfoEntity;
import com.jidouauto.log.service.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "InfoService")
public class InfoServiceImpl implements InfoService {

    @Autowired
    InfoDao infoDao;

    @Override
    public BaseResponse<ListBaseData<InfoEntity>> getInfos(int page, int pageSize) {
        BaseResponse<ListBaseData<InfoEntity>> response = new BaseResponse<>();
        ListBaseData<InfoEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<InfoEntity> lists = infoDao.getInfos((page - 1) * pageSize, pageSize);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        return response;
    }

    @Override
    public BaseResponse<ListBaseData<InfoEntity>> getInfosByChannel(int channelId, int page, int pageSize) {
        BaseResponse<ListBaseData<InfoEntity>> response = new BaseResponse<>();
        if (channelId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        ListBaseData<InfoEntity> listBaseData = new ListBaseData<>();
        if (page <= 0) {
            page = 1;
        }
        if (pageSize <= 0) {
            page = 10;
        }
        List<InfoEntity> lists = infoDao.getInfosByChannel(channelId, (page - 1) * pageSize, pageSize);
        listBaseData.setLists(lists);
        listBaseData.setPage(page);
        listBaseData.setPageSize(pageSize);
        response.setData(listBaseData);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<InfoEntity> getInfo(int infoId) {
        BaseResponse<InfoEntity> response = new BaseResponse<>();
        if (infoId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        InfoEntity infoEntity = infoDao.getInfo(infoId);
        response.setData(infoEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<InfoEntity> getInfoByPackage(String packageName) {
        BaseResponse<InfoEntity> response = new BaseResponse<>();
        if (StringUtils.isEmpty(packageName)) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        InfoEntity infoEntity = infoDao.getInfoByPackage(packageName);
        response.setData(infoEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse<Integer> insert(InfoEntity infoEntity) {
        BaseResponse<Integer> response = new BaseResponse();
        if (null == infoEntity || StringUtils.isEmpty(infoEntity.getChannelName())
                || StringUtils.isEmpty(infoEntity.getAppPackage()) || StringUtils.isEmpty(infoEntity.getAppName())
                || infoEntity.getChannelId() <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        infoDao.insert(infoEntity);
        response.setData(infoEntity.getAppId());
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse update(InfoEntity infoEntity) {
        BaseResponse response = new BaseResponse();
        if (null == infoEntity) {
            infoEntity = new InfoEntity();
        }
        infoDao.update(infoEntity);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

    @Override
    public BaseResponse delete(int infoId) {
        BaseResponse<InfoEntity> response = new BaseResponse<>();
        if (infoId <= 0) {
            response.setResultCode(LogCode.RC_PARAMETER_ERROR.getCode());
            response.setResultMessage(LogCode.RC_PARAMETER_ERROR.getMessage());
            return response;
        }
        infoDao.delete(infoId);
        response.setResultCode(LogCode.RC_SUCCESS.getCode());
        response.setResultMessage(LogCode.RC_SUCCESS.getMessage());
        return response;
    }

}
