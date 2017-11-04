package com.pure.jd.service.impl;

import com.pure.jd.Enum.VerifyCodeEnum;
import com.pure.jd.dao.IEmployeeDao;
import com.pure.jd.dao.IVerifyCodeDao;
import com.pure.jd.entity.Employee;
import com.pure.jd.entity.VerifyCode;
import com.pure.jd.service.IVerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    @Autowired
    private IVerifyCodeDao verifyCodeDao;

    public void save(VerifyCode verifyCode) {
        verifyCodeDao.save(verifyCode);
    }

    public void update(VerifyCode verifyCode) {
        verifyCodeDao.update(verifyCode);
    }

    public VerifyCode get(String telNumber, VerifyCodeEnum type) {
        return verifyCodeDao.getCode(telNumber, type);
    }

    public void delete(long telNumber) {
        verifyCodeDao.delete(telNumber);
    }

    public List<VerifyCode> listAll() {
        return verifyCodeDao.listAll();
    }

    public VerifyCode findByTelNumber(String telNumber) {
        return verifyCodeDao.findByTelNumber(telNumber);
    }

}
