package com.fanxl.aop;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/28 0028 11:28
 */
public class ProxyMain {

    public static void main(String[] args) {

        AtithmeticCalculator target = new AtithmeticCalculatorImpl();
        AtithmeticCalculator proxy = new AtithmeticCalculatorProxy(target).getProxy();

        int result = proxy.add(1, 10);
        System.out.println("add:" + result);

    }

}
