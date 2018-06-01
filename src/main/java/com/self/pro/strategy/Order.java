package com.self.pro.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public class Order {
    private String uid;
    private  double amount;


    public Order(String uid, double amount) {
        this.uid = uid;
        this.amount = amount;
    }

    public  PayState pay(PayType payType){

        return  payType.getPayMent().pay(uid,amount);
    }
}
