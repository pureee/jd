package com.pure.jd.dao.impl;

import com.pure.jd.Enum.VerifyCodeEnum;
import com.pure.jd.dao.IEmployeeDao;
import com.pure.jd.dao.IVerifyCodeDao;
import com.pure.jd.entity.Employee;
import com.pure.jd.entity.VerifyCode;
import com.pure.jd.utils.CodeUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;

import java.util.Date;


/**
 * Created by pure on 2017/6/16.
 */
@Repository
public class VerifyCodeDaoImpl extends BasicDaoImpl<VerifyCode> implements IVerifyCodeDao {

    private final int VALIDATE_TIME = 15 * 60;//15分钟有效

    public VerifyCode getCode(String telNumber, VerifyCodeEnum type) {
        VerifyCode code = new VerifyCode();
        code.setCode(CodeUtil.get(4));
        code.setTelNumber(telNumber);
        code.setType(type);
        Date createTime = new Date();
        code.setCreateTime(createTime);
        code.setLastVerifyDate(DateUtils.addSeconds(createTime, VALIDATE_TIME));
        super.saveOrUpdate(code);
        return code;
    }


    public VerifyCode findByTelNumber(String telNumber) {
        VerifyCode verifyCode = entityManager.find(VerifyCode.class, telNumber);
        return verifyCode;
    }
}
