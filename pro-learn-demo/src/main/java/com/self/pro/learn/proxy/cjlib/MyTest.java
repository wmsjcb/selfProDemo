package com.self.pro.learn.proxy.cjlib;

public class MyTest {
    public static void main(String[] args) {
//        Car cgCar = new Bus();
        Student student = new Student();
        student.setName("tom");
        Student cgProxy = CglibDynamicProxyTest.newProxyInstance(student.getClass());
        System.out.println(cgProxy.getName());
//        cgProxy.run();
//        cgProxy.back();
    }
}
