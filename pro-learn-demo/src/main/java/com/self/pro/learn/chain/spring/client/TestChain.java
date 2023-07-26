package com.self.pro.learn.chain.spring.client;

import com.self.pro.learn.chain.spring.handler.AbstractFilterHandler;
import com.self.pro.learn.chain.spring.handler.FirstFilterHandler;
import com.self.pro.learn.chain.spring.handler.SecondFilterHandler;
import com.self.pro.learn.chain.spring.handler.ThirdFilterHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;
@Slf4j
public class TestChain {

    public static void main(String[] args) {
//        AbstractFilterHandler handler = FilterHandlerEnumFactory.getFirstHandler();
//        handler.handler();
        Map<String, AbstractFilterHandler> filterMap = new LinkedHashMap<>();
        filterMap.put("first", new FirstFilterHandler());
        filterMap.put("second", new SecondFilterHandler());
        filterMap.put("third", new ThirdFilterHandler());
        try {
            for (Map.Entry<String, AbstractFilterHandler> handlerEntry : filterMap.entrySet()) {
                handlerEntry.getValue().handler();
            }

        }catch (Exception e){
          log.error(">>>>>>>>>>>>>>chain fail", e);
          e.printStackTrace();
        }

    }
}
