package com.self.pro.learn.chain.spring.generic.service;

public interface Chain<T> {

    void doHandler(T json);
}

