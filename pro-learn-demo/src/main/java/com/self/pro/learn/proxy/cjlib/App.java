package com.self.pro.learn.proxy.cjlib;

// 使用示例如下
public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tom");
        Student stu = (Student) new AServiceCglibProxy(new Student()).createProxy();
        System.out.println(stu.getName());
    }
}