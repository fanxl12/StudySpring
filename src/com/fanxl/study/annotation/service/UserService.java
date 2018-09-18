package com.fanxl.study.annotation.service;

import com.fanxl.study.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/18 0018 21:13
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService add...");
        userRepository.save();
    }

}
