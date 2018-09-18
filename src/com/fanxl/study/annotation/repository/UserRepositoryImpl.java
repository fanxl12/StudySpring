package com.fanxl.study.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/18 0018 21:10
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void save() {
        System.out.println("UserRepository save...");
    }
}
