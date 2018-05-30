package com.self.pro.proxy.jdk;

import com.self.pro.proxy.staticed.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class MeiPo  implements InvocationHandler{
    private Person person;

    public Object getInstance(Person person){
        //把person 值赋过去
        this.person=person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆我要开始工作了");
        method.invoke(this.person,args);
        System.out.println("找到合适的就付钱吧");
        return null;
    }

}
