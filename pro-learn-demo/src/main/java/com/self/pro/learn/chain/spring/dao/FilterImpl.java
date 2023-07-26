package com.self.pro.learn.chain.spring.dao;

import com.self.pro.learn.chain.spring.FilterEnum;
import com.self.pro.learn.chain.spring.entry.FilterEntity;

import java.util.HashMap;
import java.util.Map;

public class FilterImpl implements FilterDao {

    /**
     * 初始化，将枚举中配置的handler初始化到map中，方便获取
     */
    private static Map<Integer, FilterEntity> gatewayEntityMap = new HashMap<>();

    static {
        FilterEnum[] values = FilterEnum.values();
        for (FilterEnum value : values) {
            FilterEntity gatewayEntity = value.getGameEntity();
            gatewayEntityMap.put(gatewayEntity.getHandlerId(), gatewayEntity);
        }
    }

    @Override
    public FilterEntity getGameEntity(Integer handlerId) {
        return gatewayEntityMap.get(handlerId);
    }

    @Override
    public FilterEntity getFirstGameEntity() {
        for (Map.Entry<Integer, FilterEntity> entry : gatewayEntityMap.entrySet()) {
            FilterEntity value = entry.getValue();
            //  没有上一个handler的就是第一个
            if (value.getPreHandlerId() == null) {
                return value;
            }
        }
        return null;
    }
}