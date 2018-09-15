package com.fanxl.study.relation;

import com.fanxl.study.autowire.Address;
import com.fanxl.study.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 18:19
 */
public class RelationMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-relation.xml");
        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Address address1 = (Address) ctx.getBean("address1");
        System.out.println(address1);

        Address address3 = (Address) ctx.getBean("address3");
        System.out.println(address3);

        Address address5 = (Address) ctx.getBean("address5");
        System.out.println(address5);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

}
