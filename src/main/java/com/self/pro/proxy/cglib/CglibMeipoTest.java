package com.self.pro.proxy.cglib;

import com.self.pro.proxy.staticed.Person;

/**
 * Created by chenbinbin1 on 2018/5/31.
 */
public class CglibMeipoTest {
    public static void main(String[] args) {

        Person person = null;
        try {
            person = (ZhangSan) new CglibMeipo().getInstance(ZhangSan.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        person.findLove();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");

    }
}
