package com.fanxl.study.scope;

import com.fanxl.study.autowire.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 18:19
 */
public class ScopeMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
        Car card = (Car) ctx.getBean("car");
        Car card1 = (Car) ctx.getBean("car");
        System.out.println(card == card1);

    }

}
