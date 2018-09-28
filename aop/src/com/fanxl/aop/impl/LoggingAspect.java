package com.fanxl.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/28 0028 11:56
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int com.fanxl.aop.impl.AtithmeticCalculator.add(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        System.out.println("The method " + methodName + " begins with " + args);
    }


}
