package com.self.pro.design.strategy;

/**
 * Created by chenbinbin1 on 2018/6/1.
 */
public interface PayMent {

    PayState pay(String uid,double amount);

}
