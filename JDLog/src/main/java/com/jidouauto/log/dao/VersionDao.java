package com.jidouauto.log.dao;

import com.jidouauto.log.model.VersionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VersionDao {

    //获取所有的版本信息
    List<VersionEntity> getVersions(@Param("page") int page, @Param("pageSize") int pageSize);

    //获取对应应用的所有版本信息
    List<VersionEntity> getVersionsByInfoId(@Param("page") int page, @Param("pageSize") int pageSize
            , @Param("appId") int appId);

    //根据版本ID获取版本信息
    VersionEntity getVersionByVersionId(@Param("versionId") int versionId);

    //根据版本ID获取版本信息
    VersionEntity getVersionByVersionName(@Param("appId") int appId, @Param("versionName") String versionName);

    //插入版本信息
    void insert(VersionEntity versionEntity);

    //更新版本信息
    void update(VersionEntity versionEntity);

    //删除版本信息
    void delete(@Param("versionId") int versionId);

}
