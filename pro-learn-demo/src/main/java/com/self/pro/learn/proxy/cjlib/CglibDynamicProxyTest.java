package com.self.pro.learn.proxy.cjlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyTest implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept执行完毕");
        return methodProxy.invokeSuper(o,objects);
    }

    public static <T> T newProxyInstance(Class<T> targetInstanceClazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibDynamicProxyTest());
        return (T)enhancer.create();
    }
}

