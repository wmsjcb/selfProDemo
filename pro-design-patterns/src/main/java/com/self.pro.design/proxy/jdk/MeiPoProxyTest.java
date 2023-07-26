package com.self.pro.design.proxy.jdk;


import com.self.pro.design.proxy.staticed.Person;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class MeiPoProxyTest {
    public static void main(String[] args) {
        //必须是接口才能调用
        Person person = (Person) new MeiPo().getInstance(new ZhangSan());
        System.out.println(person.getClass());
        person.findJob();

    }
}
