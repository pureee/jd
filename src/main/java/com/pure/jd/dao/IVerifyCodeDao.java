package com.pure.jd.dao;


import com.pure.jd.Enum.VerifyCodeEnum;
import com.pure.jd.entity.VerifyCode;

/**
 * Created by pure on 2017/6/16.
 */
public interface IVerifyCodeDao extends IBasicDao<VerifyCode>{

    VerifyCode getCode(String telNumber, VerifyCodeEnum type);

    VerifyCode findByTelNumber(String telNumber);
}
