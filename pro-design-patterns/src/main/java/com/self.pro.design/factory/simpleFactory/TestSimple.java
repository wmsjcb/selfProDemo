package com.self.pro.design.factory.simpleFactory;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class TestSimple {
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.getPhoneName("sanxing"));
    }

}
