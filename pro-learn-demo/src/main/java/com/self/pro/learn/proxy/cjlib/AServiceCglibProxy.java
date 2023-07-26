package com.self.pro.learn.proxy.cjlib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 使用 CGLIB 创建代理
public class AServiceCglibProxy {

    private Object service;

    public AServiceCglibProxy(Object service) {
        this.service = service;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(this.service.getClass().getInterfaces());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                long start = System.currentTimeMillis();

                Object result = method.invoke(AServiceCglibProxy.this.service, args);

                long cost = System.currentTimeMillis() - start;
                System.out.println("cost time: " + cost);

                return result;
            }
        });
        return enhancer.create();
    }

}


