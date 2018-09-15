package com.fanxl.study.collections;

import com.fanxl.study.Car;

import java.util.Map;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 16:58
 */
public class Student {

    private String name;

    private Map<String, Car> carMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }
}
