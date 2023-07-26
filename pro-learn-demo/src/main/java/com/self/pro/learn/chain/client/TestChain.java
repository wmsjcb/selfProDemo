package com.self.pro.learn.chain.client;

import com.self.pro.learn.chain.factory.FilterHandlerEnumFactory;
import com.self.pro.learn.chain.handler.AbstractFilterHandler;

public class TestChain {

    public static void main(String[] args) {
        AbstractFilterHandler handler = FilterHandlerEnumFactory.getFirstHandler();
        handler.handler();
    }
}
