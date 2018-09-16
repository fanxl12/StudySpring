package com.fanxl.study.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 实例工厂方法，即先需要创建工厂方法本身，
 * 再调用工厂实例方法来返回Bean的实例
 * @author: fanxl
 * @date: 2018/9/16 0016 14:51
 */
public class InstanceCarFactory {

    private Map<String, Car> carMap;

    public InstanceCarFactory() {
        carMap = new HashMap<>();
        carMap.put("audi", new Car("audi", 300000));
        carMap.put("ford", new Car("ford", 400000));
    }

    public Car getCar(String brand) {
        return carMap.get(brand);
    }

}
