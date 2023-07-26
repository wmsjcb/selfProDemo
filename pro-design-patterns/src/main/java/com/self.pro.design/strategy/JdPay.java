package com.self.pro.design.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public class JdPay implements PayMent {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用京东支付");
        return new PayState(200,"支付成功",35.64);
    }
}
