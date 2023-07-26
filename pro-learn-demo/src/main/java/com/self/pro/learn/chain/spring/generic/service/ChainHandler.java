package com.self.pro.learn.chain.spring.generic.service;

public interface ChainHandler<T> {

    void hander(T param, Chain chain);
}
