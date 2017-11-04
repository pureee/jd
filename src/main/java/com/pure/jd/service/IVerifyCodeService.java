package com.pure.jd.service;

import com.pure.jd.Enum.VerifyCodeEnum;
import com.pure.jd.entity.Employee;
import com.pure.jd.entity.VerifyCode;

import java.util.List;

/**
 * Created by pure on 2017/6/16.
 */
public interface IVerifyCodeService {

    void save(VerifyCode verifyCode);

    void update(VerifyCode verifyCode);

    VerifyCode get(String telNumber, VerifyCodeEnum type);

    void delete(long telNumber);

    List<VerifyCode> listAll();

    VerifyCode findByTelNumber(String telNumber);
}
