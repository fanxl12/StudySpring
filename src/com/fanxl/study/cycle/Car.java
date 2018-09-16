package com.fanxl.study.cycle;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/16 0016 9:05
 */
public class Car {

    public Car() {
        System.out.println("Car's Constructor...");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}
