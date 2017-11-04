package com.pure.jd.web.controller;

import com.pure.jd.entity.Employee;
import com.pure.jd.entity.User;
import com.pure.jd.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pure on 2017/6/17.
 */
@Controller
public class LoginController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/login")
    public void login(User user){


    }

}
