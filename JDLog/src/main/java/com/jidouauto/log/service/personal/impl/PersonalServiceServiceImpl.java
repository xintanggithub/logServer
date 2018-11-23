package com.jidouauto.log.service.personal.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jidouauto.log.dao.PersonalDao;
import com.jidouauto.log.model.PersonalEntity;
import com.jidouauto.log.service.personal.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "PersonalService")
public class PersonalServiceServiceImpl implements PersonalService {

    @Autowired
    PersonalDao personalDao;

    @Override
    public PageInfo<PersonalEntity> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonalEntity> response = personalDao.getAll();
        return new PageInfo(response);
    }
}
