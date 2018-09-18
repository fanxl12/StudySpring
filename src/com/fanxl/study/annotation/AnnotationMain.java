package com.fanxl.study.annotation;

import com.fanxl.study.annotation.controller.UserController;
import com.fanxl.study.annotation.repository.UserRepositoryImpl;
import com.fanxl.study.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/16 0016 14:29
 */
public class AnnotationMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
        TestObject testObject = (TestObject) ctx.getBean("testObject");
        System.out.println(testObject);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

        UserService userService = (UserService) ctx.getBean("userService");
        System.out.println(userService);

        UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
        System.out.println(userRepository);

    }

}
