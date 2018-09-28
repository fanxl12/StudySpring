package com.fanxl.aop;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/28 0028 11:16
 */
public class AtithmeticCalculatorImpl implements AtithmeticCalculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
