package com.pure.jd.web.controller;

import com.pure.jd.Enum.VerifyCodeEnum;
import com.pure.jd.entity.VerifyCode;
import com.pure.jd.service.IVerifyCodeService;
import com.pure.jd.utils.CodeUtil;
import com.pure.jd.utils.Const;
import com.pure.jd.utils.MD5;
import com.pure.jd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pure on 2017/6/30.
 * 验证码控制器
 */
@Controller
@RequestMapping("/verifyController")
public class VerifyCodeController {

    @Autowired
    private IVerifyCodeService vervifyCodeService;

    /**
     * 不需要登录
     * @param telNumber
     * @return
     */
    @RequestMapping(value = "/getRegisterVerifyCode.do", method = RequestMethod.POST)
    @ResponseBody
    public Result getRegisterVerifyCode(String telNumber) {
        return new Result(vervifyCodeService.get(telNumber, VerifyCodeEnum.REGISTER_VERIFY));
    }
    //不需要登录
    @RequestMapping(value = "/getVerifyCodeImg.do", method = RequestMethod.GET)
    public void getVerifyCodeImge(HttpServletRequest request, HttpServletResponse response, long a) {
        CodeUtil.getVerifyCodeImg(request, response);
    }
    //不需要登录
    @RequestMapping(value = "/verifyCodeImg.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Boolean> varifyCodeImg(HttpServletRequest request, HttpServletResponse response, String codeImg) {
        Map<String, Boolean> map = new HashMap<>();
        String code = (String) request.getSession().getAttribute(Const.VERIFY_CODE_IMG);
        if (code.equalsIgnoreCase(codeImg)) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;
    }

    //不需要登录
    @RequestMapping(value = "/verifyPhoneVerifyCode.do", method = RequestMethod.POST)
    @ResponseBody
    public Result verifyPhoneVerifyCode(String telNumber, String verifyCode) {
        Result result = new Result();
        if (telNumber.contains(" ") || verifyCode.contains(" ")) {
            result.setMessage("手机号码或验证码输入格式有误,请重新出入");
        }
        boolean success = false;
        VerifyCode code = vervifyCodeService.findByTelNumber(telNumber);
        if (code != null) {
            if (code.getCode().equalsIgnoreCase(verifyCode)) {
                success = true;
            }
        }
        result.setSuccess(success);
        return result;
    }

}
