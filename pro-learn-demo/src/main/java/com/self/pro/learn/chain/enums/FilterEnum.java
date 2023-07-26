package com.self.pro.learn.chain.enums;

import com.self.pro.learn.chain.entry.FilterEntity;
import com.self.pro.learn.chain.handler.FirstFilterHandler;
import com.self.pro.learn.chain.handler.SecondFilterHandler;
import com.self.pro.learn.chain.handler.ThirdFilterHandler;

public enum FilterEnum {

    FIRST_HANDLER(new FilterEntity(1, "首要处理环节", FirstFilterHandler.class.getName(), null, 2)),
    SECOND_HANDLER(new FilterEntity(2, "二次处理环节", SecondFilterHandler.class.getName(), 1, 3)),
    THIRD_HANDLER(new FilterEntity(3, "三次处理环节", ThirdFilterHandler.class.getName(), 2, null));

    FilterEntity filterEntity;

    public FilterEntity getGameEntity() {
        return filterEntity;
    }

    FilterEnum(FilterEntity filterEntity) {
        this.filterEntity = filterEntity;
    }
}


