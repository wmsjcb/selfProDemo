package com.self.pro.learn.chain.spring.dao;

import com.self.pro.learn.chain.spring.entry.FilterEntity;

public interface FilterDao {
    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    FilterEntity getGameEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    FilterEntity getFirstGameEntity();
}