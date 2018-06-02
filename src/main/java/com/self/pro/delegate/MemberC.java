package com.self.pro.delegate;

public class MemberC implements ITarget{
    @Override
    public void doWork(String commad) {
        System.out.println("我是员工C，我擅长干"+commad+"的工作");
    }

}
