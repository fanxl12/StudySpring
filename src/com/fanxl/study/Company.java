package com.fanxl.study;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 16:18
 */
public class Company {

    private String name;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(){}

    public Company(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return name + " - " +  car.toString();
    }
}
