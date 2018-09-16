package com.fanxl.study.spel;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 17:38
 */
public class Person {

    private String name;

    /**
     * 引用address的city
     */
    private String city;

    /**
     * 根据car的price确定info，car的price>=300000 金领
     * 否则为 白领
     */
    private String info;

    private Car car;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                ", car=" + car +
                '}';
    }
}
