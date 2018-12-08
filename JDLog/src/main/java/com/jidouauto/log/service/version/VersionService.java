package com.jidouauto.log.service.version;

import com.jidouauto.log.base.BaseResponse;
import com.jidouauto.log.base.ListBaseData;
import com.jidouauto.log.model.VersionEntity;

public interface VersionService {

    //获取所有的版本信息
    BaseResponse<ListBaseData<VersionEntity>> getVersions(int page, int pageSize);

    //获取对应应用的所有版本信息
    BaseResponse<ListBaseData<VersionEntity>> getVersionsByInfoId(int page, int pageSize, int appId);

    //根据版本ID获取版本信息
    BaseResponse<VersionEntity> getVersionByVersionId(int versionId);

    //插入版本信息
    BaseResponse<Integer> insert(VersionEntity versionEntity);

    //更新版本信息
    BaseResponse update(VersionEntity versionEntity);

    //删除版本信息
    BaseResponse delete(int versionId);

}
