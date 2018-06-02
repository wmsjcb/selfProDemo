package com.self.pro.delegate;

public class MemberA implements ITarget{
    @Override
    public void doWork(String commad) {
        System.out.println("我是员工A，我擅长干"+commad+"的工作");
    }

}
