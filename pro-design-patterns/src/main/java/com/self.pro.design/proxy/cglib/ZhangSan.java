package com.self.pro.design.proxy.cglib;


import com.self.pro.design.proxy.staticed.Person;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class ZhangSan implements Person {
    @Override
    public void findLove() {
        System.out.println("我需要个对象");
        System.out.println("白富美");
        System.out.println("有钱");
    }

    @Override
    public void findJob() {
        System.out.println("我需要个工作");
        System.out.println("加班少");
        System.out.println("挣钱多");
    }
}
