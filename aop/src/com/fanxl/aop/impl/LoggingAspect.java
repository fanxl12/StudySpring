package com.fanxl.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    /**
     * 定义一个方法，用户声明切入点表达式，一般的该方法不再需要写入其他代码
     */
    @Pointcut("execution(* com.fanxl.aop.impl.*.*(int, int))")
    public void declareJointPointExpression(){}

    @Before("execution(public int com.fanxl.aop.impl.AtithmeticCalculator.add(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    // 后置通知，在目标方法执行后执行(无论是否发生异常，都会执行)
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " end" );
    }

    // 返回通知，方法正常执行完返回
    @AfterReturning(value = "declareJointPointExpression()",
        returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " end with " + result);
    }

    // 在目标方法出现异常的时候执行
    // 可以访问到异常对象，且可以指定在出现特定异常时执行通知代码
    @AfterThrowing(value = "declareJointPointExpression()",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, NullPointerException ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception:" + ex);
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint类型参数
     * 环绕通知类似于动态代理全过程 ProceedingJoinPoint的参数key决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjd
     */
    @Around("declareJointPointExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        try {
            result = pjd.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
