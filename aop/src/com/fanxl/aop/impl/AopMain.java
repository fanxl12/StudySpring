package com.fanxl.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/28 0028 11:53
 */
public class AopMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AtithmeticCalculator atithmeticCalculator = context.getBean(AtithmeticCalculator.class);

        int result = atithmeticCalculator.add(1, 10);

        System.out.println("result:" + result);
    }

}
