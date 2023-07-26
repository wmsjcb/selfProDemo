package com.self.pro.learn.strategy.client;

import com.self.pro.learn.strategy.factory.StrategyHandlerFactory;
import com.self.pro.learn.strategy.service.impl.AdvanceMemberStrategy;
import com.self.pro.learn.strategy.context.MemberContext;
import com.self.pro.learn.strategy.enums.SubCostTypeEnum;
import com.self.pro.learn.strategy.service.MemberStrategy;
import com.self.pro.learn.strategy.service.impl.IntermediateMemberStrategy;
import com.self.pro.learn.strategy.service.impl.PrimaryMemberStrategy;

// 测试类
public class Application {
    static {
        //工厂模式
        StrategyHandlerFactory.register(SubCostTypeEnum.GREATER0_IN_0UP,new PrimaryMemberStrategy());
        StrategyHandlerFactory.register(SubCostTypeEnum.EQUAL0_OUT_0DOWN,new IntermediateMemberStrategy());
    }
    public static void main(String[] args) {

//        MemberStrategy memberStrategy = StrategyHandlerFactory.getInvokeStrategyMap(SubCostTypeEnum.GREATER0_IN_0UP);
//        System.out.println("test>>>>>>>>>>>>:" + memberStrategy.calcPrice(300,2));

        // 具体行为策略
        MemberStrategy primaryMemberStrategy = new PrimaryMemberStrategy(); // 接口回调（向上转型）
        MemberStrategy intermediateMemberStrategy = new IntermediateMemberStrategy();
        MemberStrategy advanceMemberStrategy = new AdvanceMemberStrategy();

        // 用户选择不同策略
        MemberContext primaryContext = new MemberContext(primaryMemberStrategy);
        MemberContext intermediateContext = new MemberContext(intermediateMemberStrategy);
        MemberContext advanceContext = new MemberContext(advanceMemberStrategy);

        //计算一本300块钱的书
        System.out.println("普通会员的价格："+ primaryContext.qoutePrice(300,1));// 普通会员：300
        System.out.println("中级会员的价格："+ intermediateContext.qoutePrice(300,1));// 中级会员 270
        System.out.println("高级会员的价格："+ advanceContext.qoutePrice(300,1));// 高级会员240
    }
}

