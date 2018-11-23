package com.jidouauto.log.service.personal;

import com.github.pagehelper.PageInfo;
import com.jidouauto.log.model.PersonalEntity;

public interface PersonalService {
    PageInfo<PersonalEntity> getAll(int pageNum, int pageSize);
}
