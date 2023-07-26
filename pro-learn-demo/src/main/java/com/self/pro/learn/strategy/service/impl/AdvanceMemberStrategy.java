package com.self.pro.learn.strategy.service.impl;

import com.self.pro.learn.strategy.service.MemberStrategy;
import org.springframework.stereotype.Service;

// 高级会员类 20%折扣
@Service("advanceMemberStrategy")
public class AdvanceMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        double money = price * n - price * n * 0.2;
        return money;
    }
}

