package com.jidouauto.log.dao;

import com.jidouauto.log.model.InfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoDao {

    //获取所有应用
    List<InfoEntity> getInfos(@Param("page") int page, @Param("pageSize") int pageSize);

    //获取对应渠道所有应用
    List<InfoEntity> getInfosByChannel(@Param("channelId") int channelId, @Param("page") int page
            , @Param("pageSize") int pageSize);

    //根据应用ID获取应用信息
    InfoEntity getInfo(@Param("appId") int appId);

    InfoEntity getInfoByPackage(@Param("packageName") String packageName);

    //插入应用
    void insert(InfoEntity infoEntity);

    //更新应用
    void update(InfoEntity InfoEntity);

    //删除应用信息
    void delete(@Param("appId") int appId);

}
