package com.fanxl.study.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/18 0018 20:52
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 返回Bean对象
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car(brand, 500000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
