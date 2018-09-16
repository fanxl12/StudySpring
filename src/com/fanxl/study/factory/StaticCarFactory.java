package com.fanxl.study.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 静态的工厂方法，直接调用某一个类的静态方法就可以返回Bean的实例
 * @author: fanxl
 * @date: 2018/9/16 0016 14:22
 */
public class StaticCarFactory {

    private static Map<String, Car> carMap = new HashMap<>();

    static {
        carMap.put("audi", new Car("audi", 300000));
        carMap.put("ford", new Car("ford", 400000));
    }

    public static Car getCar(String name) {
        return carMap.get(name);
    }

}
