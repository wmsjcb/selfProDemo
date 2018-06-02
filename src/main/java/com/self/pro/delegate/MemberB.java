package com.self.pro.delegate;

public class MemberB implements ITarget{
    @Override
    public void doWork(String commad) {
        System.out.println("我是员工B，我擅长干"+commad+"的工作");
    }

}
