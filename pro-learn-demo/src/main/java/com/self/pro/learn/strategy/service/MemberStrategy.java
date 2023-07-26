package com.self.pro.learn.strategy.service;

public interface MemberStrategy {
    // 一个计算价格的抽象方法
    //price商品的价格 n商品的个数
    public double calcPrice(double price, int n);
}

