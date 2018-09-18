package com.fanxl.study.annotation.controller;

import com.fanxl.study.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/18 0018 21:16
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public void execute() {
        System.out.println("UserController execute...");
        userService.add();
    }

}
