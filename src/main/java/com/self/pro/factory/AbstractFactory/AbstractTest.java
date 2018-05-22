package com.self.pro.factory.AbstractFactory;

public class AbstractTest {
    public static void main(String[] args) {

        PhoneFactory factory = new PhoneFactory();
        System.out.println(factory.getApple());

    }
}
