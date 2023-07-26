package com.self.pro.learn.strategy.factory;

import com.self.pro.learn.strategy.enums.SubCostTypeEnum;
import com.self.pro.learn.strategy.service.MemberStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyHandlerFactory {
    private static Map<SubCostTypeEnum, MemberStrategy> strategyMap = new ConcurrentHashMap<>();
 
    /**
     * 根据 SubCostTypeEnum 获取对应的handler实现
     *
     * @param subCostType
     * @return
     */
    public static MemberStrategy getInvokeStrategyMap(SubCostTypeEnum subCostType) {
        return strategyMap.get(subCostType);
    }
 
    /**
     * 注册
     *
     * @param subCostType
     * @param handler
     */
    public static void register(SubCostTypeEnum subCostType, MemberStrategy handler) {
        if (null == subCostType || null == handler) {
            return;
        }
        strategyMap.put(subCostType, handler);
    }
}