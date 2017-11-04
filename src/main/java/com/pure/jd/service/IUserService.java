package com.pure.jd.service;

import com.pure.jd.entity.Employee;
import com.pure.jd.entity.User;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
public interface IUserService {

    void save(User user);

    void update(User user);

    User get(long id);

    void delete(long id);

    List<User> listAll();

    boolean checkPhoneExsit(String phone);
}
