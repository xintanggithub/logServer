package com.jidouauto.log.dao;

import com.jidouauto.log.model.LogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {

    List<LogEntity> getLogs(@Param("page") int page, @Param("pageSize") int pageSize);

    List<LogEntity> getLogsByVersionId(@Param("page") int page, @Param("pageSize") int pageSize,
                                       @Param("versionId") int versionId);

    LogEntity getLogById(@Param("logId") int logId);

    //插入版本信息
    void insert(LogEntity logEntity);

    //更新版本信息
    void update(LogEntity logEntity);

    //删除版本信息
    void delete(@Param("logId") int logId);

}
