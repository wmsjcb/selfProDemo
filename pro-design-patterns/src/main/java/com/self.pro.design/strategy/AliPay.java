package com.self.pro.design.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public class AliPay implements PayMent {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用支付宝支付");
        return new PayState(200,"支付成功",amount);
    }
}
