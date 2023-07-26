package com.self.pro.design.factory.methodFactory;

/**
 * Created by chenbinbin1 on 2018/5/22.
 */
public class MethodTest {
    public static void main(String[] args) {
        Factory factory=new AppleFactory();
        System.out.println(factory.getPhone().getName());
    }
}
