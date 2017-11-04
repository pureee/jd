package com.pure.jd.service.impl;

import com.pure.jd.dao.IEmployeeDao;
import com.pure.jd.dao.IUserDao;
import com.pure.jd.entity.Employee;
import com.pure.jd.entity.User;
import com.pure.jd.service.IEmployeeService;
import com.pure.jd.service.IUserService;
import com.pure.jd.utils.Const;
import com.pure.jd.utils.MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

     public void save(User user) {
         String password = Const.ENCRIPY_PASSWORD_PERFIX + user.getPassword() + Const.ENCRIPY_PASSWORD_SUFFIX;
         user.setPassword(MD5.encode(password));
         userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User get(long id) {
        return userDao.get(id);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public List<User> listAll() {
        return userDao.listAll();
    }

    public boolean checkPhoneExsit(String phone) {
        return userDao.checkPhoneExsit(phone);
    }

}
