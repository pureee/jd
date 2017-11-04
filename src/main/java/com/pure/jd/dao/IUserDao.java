package com.pure.jd.dao;


import com.pure.jd.entity.User;

/**
 * Created by pure on 2017/6/16.
 */
public interface IUserDao extends IBasicDao<User>{

    boolean checkPhoneExsit(String phone);
}
