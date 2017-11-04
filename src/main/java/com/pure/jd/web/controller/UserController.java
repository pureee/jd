package com.pure.jd.web.controller;

import com.pure.jd.entity.Employee;
import com.pure.jd.entity.User;
import com.pure.jd.service.IEmployeeService;
import com.pure.jd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pure on 2017/6/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //不需要登录
    @RequestMapping(value = "/checkPhoneExist", method = RequestMethod.POST)
    public void checkPhoneExist(HttpServletRequest request, HttpServletResponse response, String phone) {
        boolean isCanRegiste = false;//是否可以注册
        String message = "";
        if (phone.contains(" ")) {
            message = "输入格式有误";
        } else {
            isCanRegiste = userService.checkPhoneExsit(phone.trim());
            if (isCanRegiste == false) {
                message = "该手机号码[" + phone + "]已被注册";
            }
        }
        try {
            response.reset();
            response.setContentType("application/x-javascript;charset=UTF-8");
            response.getWriter().write("{\"success\":" + isCanRegiste + ",\"message\":'" + message + "'}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //不需要登录
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response, User u) {
        System.out.println(u);
        boolean isNotExsit = userService.checkPhoneExsit(u.getPhone());
        if (isNotExsit) {
            try {
                userService.save(u);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
