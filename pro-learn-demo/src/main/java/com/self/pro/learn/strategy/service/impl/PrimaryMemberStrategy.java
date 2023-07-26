package com.self.pro.learn.strategy.service.impl;

import com.self.pro.learn.strategy.service.MemberStrategy;
import org.springframework.stereotype.Service;

// 普通会员——不打折
@Service("primaryMemberStrategy")
public class PrimaryMemberStrategy implements MemberStrategy { // 实现策略
    //重写策略方法具体实现功能
    @Override
    public double calcPrice(double price, int n) {
        return price * n;
    }
}
