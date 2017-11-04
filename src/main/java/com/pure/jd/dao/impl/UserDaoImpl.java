package com.pure.jd.dao.impl;

import com.pure.jd.dao.IUserDao;
import com.pure.jd.dao.impl.BasicDaoImpl;
import com.pure.jd.entity.Employee;
import com.pure.jd.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


/**
 * Created by pure on 2017/6/16.
 */
@Repository
public class UserDaoImpl extends BasicDaoImpl<User> implements IUserDao {


    @Override
    public boolean checkPhoneExsit(String phone) {
        String hql = "SELECT phone FROM user WHERE phone = '" + phone + "'";
        Query query = entityManager.createNativeQuery(hql);
        List resultList = query.getResultList();
        if (resultList.size() == 0) {
            return true;//号码不存在,可以注册,返回true
        } else {
            return false;//号码已存在,不可以注册
        }

    }
}
