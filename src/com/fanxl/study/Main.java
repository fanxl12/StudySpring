package com.fanxl.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 14:19
 */
public class Main {

    public static void main(String[] args) {

        // 1.创建Spring的IOC容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2.从IOC容器中获取Bean实例 name是xml配置bean的id
        Person person = (Person) ctx.getBean("person");

        // 另外一种获取实例的方式，邀请xml中只配置了一个bean， 如果有多个会报错
        Person p = ctx.getBean(Person.class);

        // 3.调用方法
        person.sayName();
        p.sayName();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car1 = (Car) ctx.getBean("car1");
        System.out.println(car1);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);

    }

}
