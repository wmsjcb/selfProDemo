package com.self.pro.learn.strategy.service.impl;

import com.self.pro.learn.strategy.service.MemberStrategy;
import org.springframework.stereotype.Service;

// 中级会员 打百分之10的折扣
@Service("intermediateMemberStrategy")
public class IntermediateMemberStrategy implements MemberStrategy {
    @Override
    public double calcPrice(double price, int n) {
        double money = (price * n) - price * n * 0.1;
        return money;
    }
}

