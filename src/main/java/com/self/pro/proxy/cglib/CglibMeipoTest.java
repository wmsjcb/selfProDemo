package com.self.pro.proxy.cglib;

import com.self.pro.proxy.staticed.Person;

/**
 * Created by chenbinbin1 on 2018/5/31.
 */
public class CglibMeipoTest {
    public static void main(String[] args) {

        Person person =(ZhangSan) new CglibMeiPo().getInstance(ZhangSan.class);
        person.findLove();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");

    }
}
