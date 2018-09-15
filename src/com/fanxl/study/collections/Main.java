package com.fanxl.study.collections;

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
        Person person1 = (Person) ctx.getBean("person1");

        System.out.println(person1);

    }

}
