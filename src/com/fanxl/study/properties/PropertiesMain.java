package com.fanxl.study.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 22:59
 */
public class PropertiesMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
        DataSource datasource = (DataSource) ctx.getBean("datasource");
        System.out.println(datasource);
    }

}
