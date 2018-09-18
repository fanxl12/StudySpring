package com.fanxl.study.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/18 0018 22:47
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }
}
