package com.jidouauto.log.dao;


import com.jidouauto.log.model.UserDomain;

import java.util.List;

public interface UserDao {


    int insert(UserDomain record);



    List<UserDomain> selectUsers();
}