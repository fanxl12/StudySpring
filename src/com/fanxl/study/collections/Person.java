package com.fanxl.study.collections;

import com.fanxl.study.Car;

import java.util.List;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 14:17
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayName() {
        System.out.println("my name is " + name);
    }

    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
