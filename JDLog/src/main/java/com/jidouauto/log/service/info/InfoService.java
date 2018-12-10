package com.jidouauto.log.service.info;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.InfoEntity;

public interface InfoService {

    //获取所有应用
    BaseResponse<ListBaseData<InfoEntity>> getInfos(int page, int pageSize);

    //获取对应渠道所有应用
    BaseResponse<ListBaseData<InfoEntity>> getInfosByChannel(int channelId, int page, int pageSize);

    //根据应用ID获取应用信息
    BaseResponse<InfoEntity> getInfo(int infoId);

    BaseResponse<InfoEntity> getInfoByPackage(String packageName);

    //插入应用
    BaseResponse<Integer> insert(InfoEntity infoEntity);

    //更新应用
    BaseResponse update(InfoEntity infoEntity);

    //删除应用信息
    BaseResponse delete(int infoId);

}
