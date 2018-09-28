package com.fanxl.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/28 0028 11:21
 */
public class AtithmeticCalculatorProxy {

    /**
     * 要代理的对象
     */
    private AtithmeticCalculator target;

    public AtithmeticCalculatorProxy(AtithmeticCalculator target) {
        this.target = target;
    }

    public AtithmeticCalculator getProxy() {
        AtithmeticCalculator proxy = null;

        // 代理对象是由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型，即其中有哪些方法
        Class [] interfaces = new Class[]{AtithmeticCalculator.class};
        // 当调用代理对象的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             * @param proxy 正在返回的那个代理对象，一般情况下，在invoke方法中都不实使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法时，传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
                // 执行方法 result为方法的返回值
                Object result = method.invoke(target, args);
                return result;
            }
        };

        proxy = (AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);

        return proxy;
    }


}
