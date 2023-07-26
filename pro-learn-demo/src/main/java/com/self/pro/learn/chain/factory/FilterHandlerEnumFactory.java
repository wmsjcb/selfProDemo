package com.self.pro.learn.chain.factory;

import com.self.pro.learn.chain.dao.FilterDao;
import com.self.pro.learn.chain.dao.FilterImpl;
import com.self.pro.learn.chain.entry.FilterEntity;
import com.self.pro.learn.chain.handler.AbstractFilterHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilterHandlerEnumFactory {

    private static FilterDao filterDao = new FilterImpl();

    /**
     * 提供静态方法，获取第一个handler
     *
     * @return AbstractFilterHandler
     * @author <a href="https://github.com/rothschil">Sam</a>
     * @date 2022/8/4-23:50
     **/
    public static AbstractFilterHandler getFirstHandler() {

        FilterEntity firstGatewayEntity = filterDao.getFirstGameEntity();
        AbstractFilterHandler firstAbstractFilterHandler = newGatewayHandler(firstGatewayEntity);
        if (firstAbstractFilterHandler == null) {
            return null;
        }

        FilterEntity tempFilterEntity = firstGatewayEntity;
        Integer nextHandlerId = null;
        AbstractFilterHandler tempHandler = firstAbstractFilterHandler;
        // 迭代遍历所有handler，以及将它们链接起来
        while ((nextHandlerId = tempFilterEntity.getNextHandlerId()) != null) {
            FilterEntity filterEntity = filterDao.getGameEntity(nextHandlerId);
            AbstractFilterHandler abstractFilterHandler = newGatewayHandler(filterEntity);
            tempHandler.setNext(abstractFilterHandler);
            tempHandler = abstractFilterHandler;
            tempFilterEntity = filterEntity;
            log.warn("Init GatewayHandler", tempFilterEntity.getHandlerId());
        }
        // 返回第一个handler
        return firstAbstractFilterHandler;
    }

    /**
     * 反射实体化具体的处理者
     *
     * @param filterEntity
     * @return AbstractFilterHandler
     */
    private static AbstractFilterHandler newGatewayHandler(FilterEntity filterEntity) {
        try {
            String clazzName = filterEntity.getConference();
            log.error(clazzName);
            Class<?> clazz = Class.forName(clazzName);
            return (AbstractFilterHandler) clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


